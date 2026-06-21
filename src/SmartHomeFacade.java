import java.util.List;

public class SmartHomeFacade {
    private final HomeHub homeHub;

    public SmartHomeFacade(HomeHub homeHub) {
        this.homeHub = homeHub;
    }

    public void goodNightRoutine() {
        System.out.println("Metoda goodNightRoutine:");
        List<ManageableDevice> devices = homeHub.getAllDevices();

        for (ManageableDevice device : devices) {
            if (device instanceof ThermostatAdapter) {
                ((ThermostatAdapter) device).lowerTemperatureForNight();
            } else if (isLight(device)) {
                device.turnOff();
            }
        }
        System.out.println("Tryb oszczedzania energii wlaczony");

    }

    public void movieMode() {
        System.out.println("Metoda movieMode:");
        List<ManageableDevice> devices = homeHub.getAllDevices();

        for (ManageableDevice device : devices) {
            if (isLight(device)) {
                device.turnOff();
            } else if (isTv(device)) {
                device.turnOn();
            }
        }
    }

    private boolean isLight(ManageableDevice device) {
        String status = device.getStatus();
        return status.contains("Zarowka") || status.contains("Lampa");
    }

    private boolean isTv(ManageableDevice device) {
        String status = device.getStatus();
        return status.contains("Telewizor") || status.contains("TV");
    }

}
