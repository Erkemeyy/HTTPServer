import java.util.Date;

public class Utils {
    public static String getMessage(){
        return "How are u doing";
    }

    public static String getCurrentDate(){
        Date today = new Date();
        return today.toString();
    }
}