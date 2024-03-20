package com.example.corejava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegExTest {

    public static void main(String[] args) {
        // using pattern with flags
        //Pattern pattern = Pattern.compile("[a-z_A-Z0-9]+", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("fff ff_f dd aaa");
        // using Matcher find(), group(), start() and end() methods
        int count = 0;
        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group()
                    + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
            count++;
        }
        System.out.println("Count :: " + count);

        System.out.println("ab".matches("(ab)+"));
    }
}
