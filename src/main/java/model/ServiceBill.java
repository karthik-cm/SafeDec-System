package model;

import constants.SafeDecConstants;

import java.util.UUID;

public class ServiceBill {

    private final String serviceContractId;
    private final String customerName;
    private final String email;
    private final String emergencyContact1;
    private final String emergencyContact2;
    private final String address;
    private final String serviceCoverage;
    private final String serviceType;
    private final int noOfSensors;
    private final Double sensorCost;
    private final Double totalCost;

    public ServiceBill(SafeDecServiceBillBuilder builder) {
        this.serviceContractId = builder.contractServiceId;
        this.customerName = builder.customerName;
        this.email = builder.email;
        this.emergencyContact1 = builder.emergencyContact1;
        this.emergencyContact2 = builder.emergencyContact2;
        this.address = builder.address;
        this.serviceCoverage = builder.serviceCoverage;
        this.serviceType = builder.serviceType;
        this.noOfSensors = builder.noOfSensors;
        this.sensorCost = builder.sensorCost;
        this.totalCost = builder.totalCost;
    }

    public String getServiceContractId() {
        return serviceContractId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmergencyContact1() {
        return emergencyContact1;
    }

    public String getEmergencyContact2() {
        return emergencyContact2;
    }

    public String getAddress() {
        return address;
    }

    public String getServiceCoverage() {
        return serviceCoverage;
    }

    public int getNoOfSensors() {
        return noOfSensors;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Double getSensorCost() { return sensorCost; }

    public String getServiceType() {
        return serviceType;
    }




    public static class ServiceBillBuilder extends SafeDecServiceBillBuilder {

        public ServiceBillBuilder() {
            this.contractServiceId = UUID.randomUUID().toString();
        }

        @Override
        public ServiceBillBuilder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        @Override
        public SafeDecServiceBillBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public SafeDecServiceBillBuilder withEmergencyContact1(String emergencyContact1) {
            this.emergencyContact1 = emergencyContact1;
            return this;
        }

        @Override
        public SafeDecServiceBillBuilder withEmergencyContact2(String emergencyContact2) {
            this.emergencyContact2 = emergencyContact2;
            return this;
        }

        @Override
        public SafeDecServiceBillBuilder withServiceCoverageDetails(String serviceCoverage) {
            this.serviceCoverage = serviceCoverage;
            return this;
        }

        public ServiceBillBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public ServiceBillBuilder withSensorCount(int sensorCount) {
            this.noOfSensors = sensorCount;
            return this;
        }

        @Override
        public ServiceBillBuilder withSensorCost(Double sensorCost) {
            this.sensorCost = sensorCost;
            this.totalCost = sensorCost + SafeDecConstants.SERVICE_CHARGES;
            return this;
        }

        @Override
        public ServiceBillBuilder ofType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        @Override
        public ServiceBill generateBill() {
            return new ServiceBill(this);
        }

    }

}
