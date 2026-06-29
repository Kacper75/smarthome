public class OpenedState implements BlindState {

    @Override
    public void open(SmartBlind blind) {
        System.out.println("Roleta już jest otwarta.");
    }

    @Override
    public void close(SmartBlind blind) {
        System.out.println("Zamykanie rolety...");
        blind.setState(new MovingState(false));
    }

    @Override
    public void stop(SmartBlind blind) {
        System.out.println("Roleta jest otwarta, nie ma czego zatrzymywać.");
    }
}
