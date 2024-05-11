package com.example.corejava;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDiffTzMeetingTest {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /*
      1. Mohamed (in the "Europe/Belgrade" time zone)
     is creating a meeting slot with Duke in San Francisco.
    */

        // Mohamed's meeting date and time
        String mohamedTime = "2022-07-10 10:30:00";

        // Mohamed's time zone
        ZoneId mohamedZone = ZoneId.of("Europe/Belgrade");

        // Creating the meeting
        ZonedDateTime parsed = LocalDateTime.parse(mohamedTime, formatter)
                .atZone(mohamedZone);

        System.out.println("1. Mohamed booked a meeting according to his time zone at: " + parsed);
        // will print: 2022-07-10T10:30+02:00[Europe/Belgrade]

        // 2. Send the calendar invite and save the event
        Instant instant = parsed.toInstant();

        // Invitation (instant) is stored in the database
        System.out.println("2. Mohamed meeting time saved in database as UTC equivalent: " + instant);
        // will print: 2022-07-10T08:30:00Z

    /*
      Duke (in the "US/San Francisco" time zone) is viewing the meeting
  DateTime Mohamed has booked to determine when exactly the meeting is.
    */

        // Initialize Duke time zone.
        ZoneId dukeZone = ZoneId.of("America/Los_Angeles");

        // The meeting time is retrieved from the database (instant) with Duke's time zone.
        ZonedDateTime dukeTime = ZonedDateTime.ofInstant(instant, dukeZone);

        System.out.println("3.1. Duke meeting will be at (formatted): " + dukeTime.format(formatter));
        // will print: 2022-07-10 01:30:00

        System.out.println("3.2. Duke meeting will be at: " + dukeTime);
        // will print: 2022-07-10T01:30-07:00[America/Los_Angeles]

        // Mohamed would like to make sure of the meeting time
        System.out.println("4. Again, Mohamed is checking the meeting time: " + ZonedDateTime
                .ofInstant(instant, mohamedZone)
                .format(formatter)); // will print: 2022-07-10 10:30:00
    }
}
