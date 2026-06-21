public class Main {
    public static void main(String[] args) {
        try {
            SmartDevice smartDevice = new SmartDevice.Builder("10", "Czujnik ruchu")
                    .withRoom("Korytarz")
                    .withMacAddress("123:XYZ")
                    .build();
        } catch (InvalidMacAddressException e) {
            System.out.println(e.getMessage());
        }

        SmartDevice livingRoomBulbRaw = DeviceFactory.createLivingRoomBulb("20", "Żarówka");
        ManageableDevice livingRoomBulb = new EnergyMonitoringDecorator(livingRoomBulbRaw);
        HomeHub.getInstance().registerDevice(livingRoomBulb);
        livingRoomBulb.turnOn();

    }
}