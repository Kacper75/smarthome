public abstract class DeviceDecorator implements ManageableDevice {
    protected ManageableDevice wrappedDevice;

    public DeviceDecorator(ManageableDevice wrappedDevice) {
        this.wrappedDevice = wrappedDevice;
    }

    @Override
    public void turnOn() {
        wrappedDevice.turnOn();
    }

    @Override
    public void turnOff() {
        wrappedDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return wrappedDevice.getStatus();
    }

    @Override
    public Object getId() {
        return wrappedDevice.getId();
    }

    @Override
    public Object getMacAddress() {
        return wrappedDevice.getMacAddress();
    }

    @Override
    public String getRoom() {
        return wrappedDevice.getRoom();
    }

    @Override
    public String getName() {
        return wrappedDevice.getName();
    }
}
