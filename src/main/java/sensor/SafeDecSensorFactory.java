package sensor;

public interface SafeDecSensorFactory {
    Sensor createSensor(int id, SensorType type);
}
