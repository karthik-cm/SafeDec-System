package sensor;

import constants.SafeDecConstants;

public class FireSensor implements Sensor {

    private final int id;
    private boolean isOn;

    public FireSensor(int id) {
        this.id = id;
        isOn = false;
        System.out.println("Fire Detector Sensor is installed in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
    }

    public void turnOn() {
        if (!isOn) {
            System.out.println("Turning ON Fire Detector Sensor in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
            isOn = true;
        }
    }

    public void turnOff() {
        if (isOn) {
            System.out.println("Turning OFF Fire Detector Sensor in "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
            isOn = false;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public Double getCost() {
        return SafeDecConstants.FIRE_SENSOR_COST;
    }
}
