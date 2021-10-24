package wimix;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

public class DateTimeTest {

    public static String text = "Waived by WebUW automation 03/04/2021, 12:27:23 PM Europe/Minsk\nReason";

    public static void consumeArgs(String... arg1) {
        Arrays.stream(arg1).forEach(i -> System.out.println(i));
    }

    public static boolean validateDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, h:mm:ss a");
        formatter.setLenient(false);
        try {
            formatter.parse(text.split("automation")[1]);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(TimeZone.getDefault().toZoneId());

        System.out.println(validateDateFormat());

        System.out.println(" Failed (46)\n".trim().replaceAll("[^A-z0-9()\\s]",""));
    }
}