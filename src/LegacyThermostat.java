import javax.swing.plaf.IconUIResource;

public class LegacyThermostat {
    private double currentTemperature = 21.5;

    public void enableHeating(){
    }

    public void disableHeating(){
    }

    public double fetchCurrentTemperature(){
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        System.out.println("Zmieniono temperature z " + this.currentTemperature + "°C na " + currentTemperature + "°C");
        this.currentTemperature = currentTemperature;
    }
}
