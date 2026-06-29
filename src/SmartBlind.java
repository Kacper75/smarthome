public class SmartBlind implements ManageableDevice {
    private final String id;
    private final String name;
    private final String room;
    private BlindState currentState;

    public SmartBlind(String id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.currentState = new ClosedState();
    }

    public void setState(BlindState state) {
        this.currentState = state;
    }

    public String getCurrentStateName() {
        return currentState.getClass().getSimpleName();
    }

    public void openBlind() {
        currentState.open(this);
    }

    public void closeBlind() {
        currentState.close(this);
    }

    public void stopBlind() {
        currentState.stop(this);
    }


    @Override
    public void turnOn() {
        openBlind();
    }

    @Override
    public void turnOff() {
        closeBlind();
    }

    @Override
    public String getStatus() {
        return String.format("[Roleta] %s (Pokoj: %s) - Stan: %s",
                name, room == null ? "brak" : room, getCurrentStateName());
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
        return name;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}