package alert;

import constants.SafeDecConstants;
import model.User;

public class AlarmAlert implements AlertNotification {

    private final User user;

    public AlarmAlert(User user) {
        this.user = user;
    }

    @Override
    public void arm() {
        System.out.println("Hello "+user.getName() +", Alarm is triggered at " +user.getAddress());
    }

    public boolean disarm(String masterCode) {
        if (masterCode.equals(user.getMasterCode())) {
            System.out.println("Correct master code! Alarm disarmed successfully!");
            return true;
        }

        System.out.println("Incorrect master code! Alarm cannot be disarmed!");
        return false;
    }

    @Override
    public String getImage() {
        return SafeDecConstants.ALARM_IMAGE;
    }

    @Override
    public String getAlertMessage() {
        return "Hello "+user.getName() +", Alarm is triggered at " +user.getAddress();
    }
}
