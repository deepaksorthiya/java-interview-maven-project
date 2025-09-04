package com.example.datetime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatTest {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ssv");
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("LocalDateTime :: " + now + "\nFormatted :: " + now.format(dtf));
    }
}
