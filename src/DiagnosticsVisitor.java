public class DiagnosticsVisitor implements DeviceVisitor {
    private final StringBuilder report = new StringBuilder();


    @Override
    public void visit(SmartDevice device) {
        report.append(String.format("[SmartDevice] ID: %s | Nazwa: %s | Pokój: %s | MAC: %s | Firmware: v%.1f | Aktywny: %b\n",
                device.getId(),
                device.getName(),
                device.getRoom() == null ? "brak" : device.getRoom(),
                device.getMacAddress() == null ? "brak" : device.getMacAddress(),
                device.getFirmwareVersion(),
                device.isActive()));
    }

    @Override
    public void visit(ThermostatAdapter thermostat) {
        report.append(String.format("[ThermostatAdapter] ID: %s | Nazwa: %s | Pokój: %s | %s\n",
                thermostat.getId(),
                thermostat.getName(),
                thermostat.getRoom() == null ? "brak" : thermostat.getRoom(),
                thermostat.getStatus()));
    }

    @Override
    public void visit(MotionSensor sensor) {
        report.append("[MotionSensor] Wykryto obecność czujnika ruchu w systemie.\n");
    }

    @Override
    public void visit(SmartBlind blind) {
        report.append(String.format("[SmartBlind] ID: %s | Nazwa: %s | Pokój: %s | Bieżący stan: %s\n",
                blind.getId(),
                blind.getName(),
                blind.getRoom() == null ? "brak" : blind.getRoom(),
                blind.getCurrentStateName()));
    }

    public String getReport() {
        return report.toString();
    }
}
