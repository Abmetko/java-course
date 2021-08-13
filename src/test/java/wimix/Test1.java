package wimix;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test1 {

    public static String text = "13, 2012, 10:30 AM";

    public static boolean validateDateFormat(){
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy, hh:mm a");
        formatter.setLenient(false);
        try {
            formatter.parse(text);
            return true;
        }catch (ParseException e){
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateDateFormat());
    }
}