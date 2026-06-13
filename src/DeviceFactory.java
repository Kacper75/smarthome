public class DeviceFactory {
    public static SmartDevice createLivingRoomBulb(String id, String name) {
        try {
            return new SmartDevice.Builder(id, name)
                    .withRoom("Living Room")
                    .withMacAddress("AA:BB:CC:DD:EE:FF")
                    .withFirmwareVersion(2.0)
                    .build();
        } catch (InvalidMacAddressException e) {
            throw new RuntimeException(e);
        }
    }

    public static SmartDevice createBasicThermostat(String id) {
        return new SmartDevice.Builder(id, "Thermostat")
                .withFirmwareVersion(1.0)
                .build();
    }

}
