package alert;

import constants.SafeDecConstants;
import model.User;

/**
 * Factory Design Pattern (Creational) is used here.
 * This class will create required instances of Alert classes like Alarm Alert / Phone Alert
 */

public class AlertFactory {

    public AlertFactory() { }

    public static AlertFactory getInstance() {
        return new AlertFactory();
    }

    public AlertNotification getAlertForType(String alertType, User user) {
        switch (alertType) {
            case SafeDecConstants.PHONE_ALERT:
                return new PhoneAlert(user);
            case SafeDecConstants.ALARM_ALERT:
                return new AlarmAlert(user);
            default:
                return null;
        }
    }
}
