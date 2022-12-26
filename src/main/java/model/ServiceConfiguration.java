package model;

import sensor.SensorType;

public class ServiceConfiguration {

    private final SensorType sensorType;
    private final String alertType;

    public ServiceConfiguration(SensorType sensorType, String alertType) {
        this.sensorType = sensorType;
        this.alertType = alertType;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public String getAlertType() {
        return alertType;
    }
}
