package sensor;

public class SensorDecorator implements Sensor {
    Sensor baseSensor;

    public SensorDecorator(Sensor baseSensor) {
        this.baseSensor = baseSensor;
    }


    @Override
    public int getId() {
        return baseSensor.getId();
    }

    @Override
    public Double getCost() {
        return baseSensor.getCost();
    }

    @Override
    public void turnOn() {
        baseSensor.turnOn();
    }

    @Override
    public void turnOff() {
        baseSensor.turnOff();
    }

}
