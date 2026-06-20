public class ThermostatAdapter implements ManageableDevice{
    private final LegacyThermostat legacyThermostat;
    private final String id;
    private final String room;

    public ThermostatAdapter(LegacyThermostat legacyThermostat, String id, String room) {
        this.legacyThermostat = legacyThermostat;
        this.id = id;
        this.room = room;
    }

    @Override
    public void turnOn() {
        legacyThermostat.enableHeating();
    }

    @Override
    public void turnOff() {
        legacyThermostat.disableHeating();
    }

    @Override
    public String getStatus() {
        return String.format("[Termostat-Adapter] Aktualna temperatura: %.1f°C",
                legacyThermostat.fetchCurrentTemperature());
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public Object getMacAddress() {
        return null;
    }

    @Override
    public String getRoom() {
        return room;
    }

    @Override
    public String getName() {
        return "Adapter";
    }
}
