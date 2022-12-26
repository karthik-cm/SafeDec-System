package alert;

public interface AlertNotification {
    void arm();

    boolean disarm(String masterCode);

    String getImage();

    String getAlertMessage();
}
