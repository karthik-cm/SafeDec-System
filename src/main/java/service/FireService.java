package service;

import model.ServiceType;
import model.User;
import sensor.Sensor;

public class FireService extends SafeDecService {

    public FireService(User user) {
        super(user);
    }

    @Override
    public void activateService() {
        System.out.println("Turning ON selected sensors in Fire Service");
        sensorList.forEach(Sensor::turnOn);
    }

    @Override
    public void deactivateService() {
        System.out.println("Turning OFF selected sensors in Fire Service");
        sensorList.forEach(Sensor::turnOff);
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.FIRE_SERVICE;
    }

}
