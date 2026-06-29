public class ThermostatAdapter implements ManageableDevice{
    private final LegacyThermostat legacyThermostat;
    private final String id;
    private final String room;
    private  HeatingStrategy heatingStrategy;

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

    public void lowerTemperatureForNight() {
        legacyThermostat.setCurrentTemperature(19.0);
    }

    public void setStrategy(HeatingStrategy heatingStrategy) {
        this.heatingStrategy = heatingStrategy;
    }

    public void adjustTemperature(boolean isSomeoneHome) {
        if (heatingStrategy == null) {
            System.out.println("Brak ustawionej strategii ogrzewania");
            return;
        }
        double currentTemp = legacyThermostat.fetchCurrentTemperature();
        double targetTemp = heatingStrategy.calculateTargetTemperature(currentTemp, isSomeoneHome);
        legacyThermostat.setCurrentTemperature(targetTemp);
    }

}
