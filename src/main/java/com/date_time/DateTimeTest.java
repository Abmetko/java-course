package com.date_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateTimeTest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        System.out.println("Current date & time as human-readable date: " + date);
        System.out.println("Current date & time as timestamp(epoch): " + date.getTime());//since 1970

        // #1 Извлекли строку с датой и временем из ui элемента с целью проверить на корректность формата данных
        System.out.println("Valid case: " + validateDateTimeFormat("E MMM dd HH:mm:ss z yyyy", "Mon Dec 27 21:28:32 MSK 2021"));
        System.out.println("Invalid case: " + validateDateTimeFormat("E MMMM dd HH:mm:ss z yyyy", "Mon Dec 27 21:28:32 MSK 2021"));
        System.out.println("Invalid case: " + validateDateTimeFormat("E MMMM dd HH/mm/ss z yyyy", "Mon Dec 27 21:28:32 MSK 2021"));
        System.out.println("Invalid case: " + validateDateTimeFormat("E MMMM dd HH:M:ss z yyyy", "Mon Dec 27 21:28:32 MSK 2021"));
        System.out.println("Invalid case: " + validateDateTimeFormat("MMMM dd HH:M:ss z yyyy", "Mon Dec 27 21:28:32 MSK 2021"));
        System.out.println("Invalid case: " + validateDateTimeFormat("E MMMM dd HH:M:ss yyyy", "Mon Dec 27 21:28:32 MSK 2021"));

        System.out.println("\n");
        //#2 Извлекли строки ui элементов, и надо проверить, что элементы с датами расположены в правильном порядке на экране
        System.out.println("Valid sorting case: " + validateSorting(new String[]{"10/15/2021, 11:14", "10/15/2021, 11:15", "10/15/2021, 12:34"}));
        System.out.println("Invalid sorting case: " + validateSorting(new String[]{"10/15/2021, 11:15", "10/15/2021, 11:14", "10/15/2021, 12:34"}));

        System.out.println("\n");
        //#3 Проверить, что дата в ui элементе соответствует ожидаемой дате(например, текущая плюс 6 месяцев)
        System.out.println("Is actual date & time from UI and expected are equals: " + validateFutureDate("09 July 2022"));
    }

    /*
     dd-M-yyyy hh:mm:ss	        02-1-2018 06:07:59
     dd MMMM yyyy	            02 January 2018
     dd MMMM yyyy zzzz	        02 January 2018 India Standard Time
     E, dd MMM yyyy HH:mm:ss z	Tue, 02 Jan 2018 18:07:59 IST
     E MMM dd HH:mm:ss z yyyy   Mon Dec 27 21:28:32 MSK 2021
    */
    public static boolean validateDateTimeFormat(String pattern, String stringWithDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        try {
//            LocalDateTime.parse(stringWithDateTime, dateTimeFormatter);
            dateTimeFormatter.parse(stringWithDateTime);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validateSorting(String[] stringDates) {
        List<LocalDateTime> actualList = new ArrayList<>();
        for (String date : stringDates) {
            actualList.add(LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy, HH:mm")));
        }
        List<LocalDateTime> expectedList = new ArrayList<>(actualList);
        expectedList.sort(Comparator.naturalOrder());//Comparator.reverseOrder()

        return actualList.equals(expectedList);
    }

    /**
     * @param actualDateTime it's our text from UI element
     */
    public static boolean validateFutureDate(String actualDateTime) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(6);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String expectedDateTime = dateTimeFormatter.format(localDateTime);

        return expectedDateTime.equals(actualDateTime);
        /*
        Проверили, что та дата которая отображена на UI соответствует
        требованиям задачи, т.е. текущая дата/время плюс 6 месяцев.
        */
    }

    /**
     * @see ZoneId#SHORT_IDS
     */
    public static void testZonedDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, HH:mm z");

        ZonedDateTime zonedDateTimeWithTimeZone = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("Zoned: " + zonedDateTimeWithTimeZone.format(dateTimeFormatter));//Zoned: 01/09/2022, 19:58 UTC

        ZonedDateTime zonedDateTimeLocal = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("Local: " + zonedDateTimeLocal.format(dateTimeFormatter));//Local: 01/09/2022, 22:58 MSK
    }

    public static void testSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}