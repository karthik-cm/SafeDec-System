package model;

public enum ServiceType {
    SECURITY_SERVICE("Security Service"),
    FIRE_SERVICE("Fire Service");

    private final String serviceName;

    private ServiceType(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
