import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeHub {
    private static HomeHub instance;
    private List<SmartDevice> devices;

    private HomeHub() {
        devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void registerDevice(SmartDevice device) {
        for (SmartDevice existing : devices) {
            if (existing.getId().equals(device.getId())) {
                throw new DuplicateDeviceException("Urzadzenie z tym ID już istnieje!");
            }
            if (existing.getMacAddress() != null && existing.getMacAddress().equals(device.getMacAddress())) {
                throw new DuplicateDeviceException("Urzadzenie z tym MAC już istnieje!");
            }
        }
        devices.add(device);
    }

}
