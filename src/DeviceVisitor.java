public interface DeviceVisitor {
    void visit(SmartDevice device);
    void visit(ThermostatAdapter thermostat);
    void visit(MotionSensor sensor);
    void visit(SmartBlind blind);


}
