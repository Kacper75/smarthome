public class EcoStrategy implements HeatingStrategy {

    @Override
    public double calculateTargetTemperature(double currentTemp, boolean isSomeoneHome) {
        if(!isSomeoneHome){
            return 15.0;
        }
        return 19.0;
    }
}
