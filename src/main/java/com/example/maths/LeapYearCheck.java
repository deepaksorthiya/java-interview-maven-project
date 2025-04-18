package com.example.maths;

import java.time.LocalDate;
import java.time.Year;

public class LeapYearCheck {

    public static void main(String[] args) {
        System.out.println("2000 is leap year :: " + checkYear(2000));
        System.out.println("1900 is leap year :: " + checkYear(1900));
        System.out.println("1904 is leap year :: " + checkYear(1904));

        // In built
        LocalDate ldt = LocalDate.now();
        boolean isLeapYear = Year.of(2024).isLeap();
        System.out.println("2024 is leap year :: " + isLeapYear);
    }

    static boolean checkYear(int n) {

        // Check if n is divisible by 4
        if (n % 4 == 0) {

            // If it's divisible by 100, it should also be
            // divisible by 400 to be a leap year
            if (n % 100 == 0) {
                return n % 400 == 0;
            }
            return true;
        }
        return false;
    }

}
