package service;

import alert.AlertNotification;
import constants.SafeDecConstants;
import model.ServiceType;
import model.User;
import sensor.Sensor;
import sensor.SensorFactory;
import sensor.SensorType;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterator Design Pattern (Behavioral) is used here.
 */


public abstract class SafeDecService implements SensorPublisher {

    List<Sensor> sensorList;
    User serviceUser;
    AlertNotification alertNotification;

    public SafeDecService(User user) {
        this.serviceUser = user;
        this.sensorList = new ArrayList<>();
    }

    public User getServiceUser() {
        return serviceUser;
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public AlertNotification getAlertNotification() {
        return alertNotification;
    }

    public void setAlertNotification(AlertNotification alertNotification) {
        this.alertNotification = alertNotification;
    }



    public void addSensor(int id, SensorType type) {
        boolean isSensorPresent = sensorList.stream().anyMatch(sensor -> sensor.getId() == id);
        if (!isSensorPresent) {
            sensorList.add(SensorFactory.getInstance().createSensor(id, type));
        }
    }

    public void removeSensor(int id) {
        boolean sensorRemoved = sensorList.removeIf(sensor -> sensor.getId() == id);
        if (sensorRemoved){
            System.out.println("Sensor is removed at "+SafeDecConstants.BUILDING_SECTIONS.get(id) +"-" +id);
        }
    }

    public Double getTotalCost() {
        Double totalCost = 0.0;

        for (Sensor s : sensorList) {
            totalCost += s.getCost();
        }

        return totalCost;
    }

    public void triggerService() {
        if (alertNotification != null) {
            alertNotification.arm();
        }
    }

    public boolean disarmService(String masterCode) {
        if (alertNotification != null) {
            return alertNotification.disarm(masterCode);
        }
        return false;
    }

    public String getServiceCoverageDetails(){
        StringBuilder layoutDetails = new StringBuilder();
        List<String> buildingLayout = SafeDecConstants.BUILDING_SECTIONS;

        for(Sensor sensor : sensorList){
            int id = sensor.getId();

            layoutDetails.append(buildingLayout.get(id));
            layoutDetails.append("-");
            layoutDetails.append(id);
            layoutDetails.append(", ");
        }

        return layoutDetails.substring(0, layoutDetails.length() - 2);
    }

    public abstract void activateService();

    public abstract void deactivateService();

    public abstract ServiceType getServiceType();
}
