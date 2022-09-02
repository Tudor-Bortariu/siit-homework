package siit.homework10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ConvertTime {
    /**
     * This method splits a duration string result by letters and joins the elements of the resulted array using the ":"
     * delimiter for a better view of the time result.
     * @param duration is the duration result you want to convert to string.
     * @return Returns a string value from the duration.
     */
    public static String convertTime (Duration duration){
        List<String> timeList = new ArrayList<>(List.of(duration.toString().split("[a-zA-Z]+")));
        timeList.remove(0);
        return String.join(":", timeList);
    }
}
