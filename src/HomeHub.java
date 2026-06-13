import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeHub {
    private static HomeHub instance;
    private List<SmartDevice> devices;

    private HomeHub() {
        devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }
}
