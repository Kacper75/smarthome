public class MovingState implements BlindState {
    private final boolean opening;

    public MovingState(boolean opening) {
        this.opening = opening;
    }

    @Override
    public void open(SmartBlind blind) {
    }

    @Override
    public void close(SmartBlind blind) {
        if (!opening) {
            System.out.println("Roleta już się zamyka, proszę czekać.");
        } else {
            System.out.println("Roleta jest w trakcie otwierania");
        }
    }

    @Override
    public void stop(SmartBlind blind) {
        if (opening) {
            System.out.println("Zatrzymano roletę w trakcie otwierania.");
            blind.setState(new OpenedState());
        } else {
            System.out.println("Zatrzymano roletę w trakcie zamykania.");
            blind.setState(new ClosedState());
        }
    }
}

