package model;


/**
 * Builder Design Pattern (Creational) is used here.
 * This class will generate the Bill for respective usage of Fire / Security Services.
 */

public abstract class SafeDecServiceBillBuilder {

    public String contractServiceId;
    public String customerName;
    public String email;
    public String emergencyContact1;
    public String emergencyContact2;
    public String address;
    public String serviceCoverage;
    public String serviceType;
    public int noOfSensors;
    public Double sensorCost;
    public Double totalCost;

    protected SafeDecServiceBillBuilder() { }

    public abstract SafeDecServiceBillBuilder withCustomerName(String customerName);

    public abstract SafeDecServiceBillBuilder withEmail(String email);

    public abstract SafeDecServiceBillBuilder withEmergencyContact1(String emergencyContact1);

    public abstract SafeDecServiceBillBuilder withEmergencyContact2(String emergencyContact2);

    public abstract SafeDecServiceBillBuilder withServiceCoverageDetails(String serviceCoverage);

    public abstract SafeDecServiceBillBuilder withAddress(String address);

    public abstract SafeDecServiceBillBuilder withSensorCount(int sensorCount);

    public abstract SafeDecServiceBillBuilder withSensorCost(Double sensorCost);

    public abstract SafeDecServiceBillBuilder ofType(String serviceType);

    public abstract ServiceBill generateBill();
}
