package sensor;

/**
 * Factory Design Pattern (Creational) is used here.
 * This class will create required instances of Sensors classes like Fire Sensor / Motion Sensor / Motion Sensor with Camera
 */

public final class SensorFactory implements SafeDecSensorFactory {

    private static final SensorFactory sensorFactoryInstance = new SensorFactory();

    private SensorFactory() { }

    public static SensorFactory getInstance() {
        return sensorFactoryInstance;
    }

    public Sensor createSensor(int id, SensorType type) {
        Sensor sensor = null;

        switch (type) {
            case FIRE_SENSOR:
                sensor = new FireSensor(id);
                break;
            case MOTION_SENSOR_WITHOUT_CAMERA:
                sensor = new MotionSensor(id);
                break;
            case MOTION_SENSOR_WITH_CAMERA:
                sensor = new CameraDecorator(new MotionSensor(id));
                break;
        }

        return sensor;
    }
}
