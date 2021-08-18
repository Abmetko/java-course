package wimix;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Test1 {

    public static String text = "13, 2012, 10:30 AM";

    public static void consumeArgs(String... arg1) {
        Arrays.stream(arg1).forEach(i -> System.out.println(i));
    }

    public static boolean validateDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy, hh:mm a");
        formatter.setLenient(false);
        try {
            formatter.parse(text);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        consumeArgs("1");
        consumeArgs("2", "3");

    }
}