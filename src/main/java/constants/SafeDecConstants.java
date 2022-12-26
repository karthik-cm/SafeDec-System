package constants;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SafeDecConstants {

    public static final Double FIRE_SENSOR_COST = 50.00;
    public static final Double MOTION_SENSOR_COST = 55.00;
    public static final Double SENSOR_CAMERA_COST = 15.00;
    public static final Double MOTION_SENSOR_WITH_CAMERA_COST = MOTION_SENSOR_COST + SENSOR_CAMERA_COST;
    public static final Double SERVICE_CHARGES = 100.00;

    public static final String PHONE_ALERT = "Phone Alert";
    public static final String ALARM_ALERT = "Alarm Alert";

    public static final String ALARM_IMAGE = "alarm.png";
    public static final String PHONE_IMAGE = "phone.png";

    public static final String CHARGES_DETAILS = "Cost Per Sensor: Fire Sensor = $"+FIRE_SENSOR_COST +", Motion Sensor = $"+MOTION_SENSOR_COST +", Motion Sensor with Camera = $"+MOTION_SENSOR_WITH_CAMERA_COST;

    public static HashMap<Integer, int[]> BUILDING_SECTIONS_MAPPING = new HashMap<>();
    static {
        BUILDING_SECTIONS_MAPPING.put(1, new int[]{1, 2, 3, 4});
        BUILDING_SECTIONS_MAPPING.put(2, new int[]{5, 6, 7});
        BUILDING_SECTIONS_MAPPING.put(3, new int[]{8, 9, 10, 11});
    }

    public static List<String> BUILDING_SECTIONS = Arrays.asList("NA", "Office", "Office", "Office", "Office", "Office", "Conference", "Office", "Office", "Office", "Office", "Office");

    public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

}
