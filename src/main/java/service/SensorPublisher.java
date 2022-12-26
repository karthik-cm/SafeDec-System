package service;

import sensor.SensorType;

public interface SensorPublisher {

    void addSensor(int id, SensorType type);

    void removeSensor(int id);

    void activateService();

    void deactivateService();

}
