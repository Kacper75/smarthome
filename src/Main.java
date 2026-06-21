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



    }
}