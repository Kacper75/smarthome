public class ComfortStrategy implements HeatingStrategy {
    @Override
    public double calculateTargetTemperature(double currentTemp, boolean isSomeoneHome) {
        return 22.0;
    }
}
