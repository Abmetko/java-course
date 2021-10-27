package wimix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DateTimeSorting {

    private static final String dateTime_1 = "Created 10/15/2021, 11:14";
    private static final String dateTime_2 = "Created 10/15/2021, 11:18";
    private static final String dateTime_3 = "Created 10/15/2021, 12:00";

    private static List<LocalDateTime> getLocalDateTime() {
        List<String> dates = new ArrayList<>();
        dates.add(dateTime_1);
        dates.add(dateTime_2);
        dates.add(dateTime_3);

        List<LocalDateTime> localDateTimes = new ArrayList<>();

        dates.forEach(date ->
                localDateTimes.add(LocalDateTime.parse(date.replaceAll("[ A-z]", ""),
                        DateTimeFormatter.ofPattern("MM/dd/yyyy,HH:mm"))));

        return localDateTimes;
    }

    public static void main(String[] args) {
        List<LocalDateTime> actualDateTimeList = getLocalDateTime();
        List<LocalDateTime> expectedDateTime = new ArrayList<>(actualDateTimeList);
        expectedDateTime.sort(Comparator.naturalOrder());
        System.out.println(actualDateTimeList.equals(expectedDateTime));
    }
}