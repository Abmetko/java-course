package com.date_time;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeHomeWork {

    private static final String PATTERN = "E, dd MMM yyyy HH:mm:ss";

    public static String getCurrentTimeInPattern(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public static String getCurrentTimeInPatternIncreasedInMinutes(String pattern, int minutes) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(minutes);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getCurrentTimeInPatternInTimeZone(String pattern, String timeZone) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(timeZone));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(zonedDateTime);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTimeInPattern(PATTERN));
        System.out.println(getCurrentTimeInPatternIncreasedInMinutes(PATTERN, 10));
        System.out.println(getCurrentTimeInPatternInTimeZone(PATTERN, "Europe/Berlin"));
    }
}