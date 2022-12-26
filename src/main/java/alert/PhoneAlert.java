package alert;

import constants.SafeDecConstants;
import model.User;

public class PhoneAlert implements AlertNotification {

    private final User user;

    public PhoneAlert(User user) {
        this.user = user;
    }

    @Override
    public void arm() {
        System.out.println("Hello "+user.getName() +", Dialing emergency contact number " +user.getEmergencyContact1());
    }

    @Override
    public boolean disarm(String masterCode) {
        if (masterCode.equals(user.getMasterCode())) {
            System.out.println("Correct master code! Phone Alert and call is suspended!");
            return true;
        }

        System.out.println("Incorrect master code! Call in progress!");
        return false;
    }

    @Override
    public String getImage() {
        return SafeDecConstants.PHONE_IMAGE;
    }

    @Override
    public String getAlertMessage() {
        return "Hello "+user.getName() +", Dialing emergency contact number " +user.getEmergencyContact1();
    }
}
