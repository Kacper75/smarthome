import java.util.ArrayList;
import java.util.List;

public class MotionSensor {
    private final String id;
    private final List<SensorObserver> observers = new ArrayList<>();

    public MotionSensor(String id) {
        this.id = id;
    }

    void attach(SensorObserver observer) {
        observers.add(observer);
    }

    void detach(SensorObserver observer) {
        observers.remove(observer);
    }

    void detectMotion() {
        System.out.println("Czujnik ruchu " + id + ": wykryto ruch!");
        for (SensorObserver obs : observers) {
            obs.onSensorTriggered(id, "Wykryto ruch!");
        }
    }
}
