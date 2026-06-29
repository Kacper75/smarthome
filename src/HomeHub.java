import java.util.*;

public class HomeHub implements SensorObserver {
    private static HomeHub instance;
    private List<ManageableDevice> devices;

    private HomeHub() {
        devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void registerDevice(ManageableDevice device) {
        for (ManageableDevice existing : devices) {
            if (existing.getId().equals(device.getId())) {
                throw new DuplicateDeviceException("Urzadzenie z tym ID już istnieje!");
            }
            if (existing.getMacAddress() != null && existing.getMacAddress().equals(device.getMacAddress())) {
                throw new DuplicateDeviceException("Urzadzenie z tym MAC już istnieje!");
            }
        }
        devices.add(device);
    }

    public List<ManageableDevice> getDevicesByRoom(String room) {
        List<ManageableDevice> result = new ArrayList<>();
        for (ManageableDevice device : devices) {
            if (room.equals(device.getRoom())) {
                result.add(device);
            }
        }
        result.sort(Comparator.comparing(ManageableDevice::getName));
        return result;
    }

    public List<ManageableDevice> getAllDevices() {
        return new ArrayList<>(devices);
    }


    @Override
    public void onSensorTriggered(String sensorId, String eventDetails) {
        System.out.println("ALARM: Wykryto ruch z czujnika [" + sensorId + "] " + eventDetails);
    }

    public void runDiagnostics() {
        DiagnosticsVisitor visitor = new DiagnosticsVisitor();

        for (ManageableDevice device : devices) {
            device.accept(visitor);
        }

        System.out.println(visitor.getReport());
    }
}
