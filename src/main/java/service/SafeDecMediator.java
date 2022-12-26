package service;

import alert.AlertFactory;
import constants.SafeDecConstants;
import model.SafeDecServiceBillBuilder;
import model.ServiceBill;
import model.TimeFrame;
import model.User;
import sensor.SensorType;
import view.AlertNotificationDialog;
import view.BillDetailsPage;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

/**
 * Mediator Design Pattern (Behavioral) is used here.
 * This is the central mediator class which orchestrates all the activities for Fire / Security Services.
 */

public class SafeDecMediator {

    SafeDecService service;
    SafeDecServiceBillBuilder builder;
    boolean isServiceActivated;

    public SafeDecMediator(SafeDecService service, SafeDecServiceBillBuilder builder) {
        this.service = service;
        this.builder = builder;
        this.isServiceActivated = false;
    }

    public void onSensorSelection(int buttonId, SensorType type, boolean isSensorSelected) {
        if (isSensorSelected) {
            service.addSensor(buttonId, type);
        }
        else {
            service.removeSensor(buttonId);
        }
    }

    public void onSectionSelection(int sectionId, SensorType type, boolean isSectionSelected) {
        int[] sensorIds = SafeDecConstants.BUILDING_SECTIONS_MAPPING.get(sectionId);
        if (isSectionSelected) {
            Arrays.stream(sensorIds).forEach(id -> service.addSensor(id, type));
        }
        else {
            Arrays.stream(sensorIds).forEach(service::removeSensor);
        }
    }

    public void toggleServiceStatus() {
        if (isServiceActivated) {
            service.deactivateService();
            isServiceActivated = false;
        }
        else {
            service.activateService();
            isServiceActivated = true;
        }
    }

    public void scheduleService(TimeFrame timeFrame) {
        try{
            Timer timer = new Timer();

            String fromDateStr = timeFrame.getFromDate() +" " +timeFrame.getFromTime();
            String toDateStr = timeFrame.getToDate() +" " +timeFrame.getToTime();
            System.out.println("\nService is scheduled: from "+fromDateStr +" to "+toDateStr);

            // arm the service from given start time
            Date fromDateTime = SafeDecConstants.dateTimeFormat.parse(fromDateStr);
            SchedulerService schedulerService1 = new SchedulerService(this);
            timer.schedule(schedulerService1, fromDateTime);

            // disarm the service from end time
            Date toDateTime = SafeDecConstants.dateTimeFormat.parse(toDateStr);
            SchedulerService schedulerService2 = new SchedulerService(this);
            timer.schedule(schedulerService2, toDateTime);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    public void displayBillPanel() {
        User user = service.getServiceUser();

        ServiceBill bill =
                builder.withCustomerName(user.getName())
                        .withEmail(user.getEmail())
                        .withEmergencyContact1(user.getEmergencyContact1())
                        .withEmergencyContact2(user.getEmergencyContact2())
                        .withAddress(user.getAddress())
                        .withServiceCoverageDetails(service.getServiceCoverageDetails())
                        .withSensorCount(service.getSensorList().size())
                        .withSensorCost(service.getTotalCost())
                        .ofType(service.getServiceType().getServiceName())
                .generateBill();

        new BillDetailsPage(bill).launchFrame();
    }

    public void selectTriggerNotification(String alertType) {
        service.setAlertNotification(AlertFactory.getInstance().getAlertForType(alertType, service.getServiceUser()));
    }

    public void triggerAlertSimulation(String alertText) {
        if (service.getSensorList().size() == 0) {
            System.out.println("No sensors selected for Simulation. Select at least one sensor!");
            return;
        }

        // Show Alert Notification
        if(isServiceActivated){
            new AlertNotificationDialog(service, alertText).launchFrame();
        }
        else{
            System.out.println("Service is not running!");
        }
    }
}
