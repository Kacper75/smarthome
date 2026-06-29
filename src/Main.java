public class Main {
    public static void main(String[] args) {
        HomeHub homeHub = HomeHub.getInstance();

        try {
            SmartDevice motionSensor = new SmartDevice.Builder("10", "Czujnik ruchu")
                    .withRoom("Korytarz")
                    .withMacAddress("123:XYZ")
                    .build();
            homeHub.registerDevice(motionSensor);
        } catch (InvalidMacAddressException e) {
            System.out.println(e.getMessage());
        }

        try {
            SmartDevice tv = new SmartDevice.Builder("30", "Telewizor")
                    .withRoom("Sypialnia")
                    .withMacAddress("AA:11:BB:22:CC:33")
                    .build();
            homeHub.registerDevice(tv);
        } catch (InvalidMacAddressException e) {
            System.out.println(e.getMessage());
        }

        SmartDevice livingRoomBulbRaw = DeviceFactory.createLivingRoomBulb("20", "Zarowka");
        ManageableDevice livingRoomBulb = new EnergyMonitoringDecorator(livingRoomBulbRaw);
        homeHub.registerDevice(livingRoomBulb);
        livingRoomBulb.turnOn();

        ThermostatAdapter thermostatAdapter = new ThermostatAdapter(new LegacyThermostat(), "40", "Sypialnia");
        homeHub.registerDevice(thermostatAdapter);

        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(homeHub);
        smartHomeFacade.movieMode();
        smartHomeFacade.goodNightRoutine();

        HomeHub hub = HomeHub.getInstance();
        MotionSensor sensor = new MotionSensor("MS-01");

        sensor.attach(hub);
        sensor.detectMotion();

        thermostatAdapter.setStrategy(new EcoStrategy());
        thermostatAdapter.adjustTemperature(false);
        thermostatAdapter.adjustTemperature(true);

        thermostatAdapter.setStrategy(new ComfortStrategy());
        thermostatAdapter.adjustTemperature(false);

        SmartBlind bedroomBlind = new SmartBlind("60", "Roleta", "Sypialnia");
        bedroomBlind.openBlind();
        bedroomBlind.stopBlind();
        bedroomBlind.closeBlind();
        bedroomBlind.stopBlind();

        bedroomBlind.closeBlind();
        bedroomBlind.stopBlind();

        System.out.println("\nUruchamianie diagnostyki systemu...");
        homeHub.runDiagnostics();


    }
}