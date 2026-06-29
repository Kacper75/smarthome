public class ClosedState implements BlindState {

    @Override
    public void open(SmartBlind blind) {
        System.out.println("Otwieranie rolety...");
        blind.setState(new MovingState(true));
    }

    @Override
    public void close(SmartBlind blind) {
        System.out.println("Roleta już jest zamknięta.");
    }

    @Override
    public void stop(SmartBlind blind) {
        System.out.println("Roleta jest zamknięta, nie ma czego zatrzymywać.");
    }
}
