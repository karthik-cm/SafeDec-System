package sensor;

import constants.SafeDecConstants;

/**
 * Decorator Design Pattern (Structural) is used here.
 * Motion Sensor class functionality is extended by adding a Camera to it.
 */

public class CameraDecorator extends SensorDecorator {

    public CameraDecorator(Sensor baseSensor) {
        super(baseSensor);
        int id = baseSensor.getId();
        System.out.println("Added Camera to Motion Sensor in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
    }

    @Override
    public Double getCost() {
        return baseSensor.getCost() + SafeDecConstants.SENSOR_CAMERA_COST;
    }
}
