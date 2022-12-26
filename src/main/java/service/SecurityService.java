package service;

import model.ServiceType;
import model.User;
import sensor.Sensor;

public class SecurityService extends SafeDecService {

    public SecurityService(User user) {
        super(user);
    }

    @Override
    public void activateService() {
        System.out.println("Turning ON selected sensors in Security Service");
        sensorList.forEach(Sensor::turnOn);
    }

    @Override
    public void deactivateService() {
        System.out.println("Turning OFF selected sensors in Security Service");
        sensorList.forEach(Sensor::turnOff);
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.SECURITY_SERVICE;
    }

}
