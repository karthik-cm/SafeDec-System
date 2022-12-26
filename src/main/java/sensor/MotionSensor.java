package sensor;

import constants.SafeDecConstants;

public class MotionSensor implements Sensor {

    private final int id;
    private boolean isOn;

    public MotionSensor(int id) {
        this.id = id;
        isOn = false;
        System.out.println("Motion Sensor is installed in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
    }

    public void turnOn() {
        if (!isOn) {
            System.out.println("Turning ON Motion Sensor in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
            isOn = true;
        }
    }

    public void turnOff() {
        if (isOn) {
            System.out.println("Turning OFF Motion Sensor in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
            isOn = false;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public Double getCost() {
        return SafeDecConstants.MOTION_SENSOR_COST;
    }
}
