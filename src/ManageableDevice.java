public interface ManageableDevice {
    void turnOn();
    void turnOff();
    String getStatus();

    Object getId();
    Object getMacAddress();
    String getRoom();
    String getName();
}
