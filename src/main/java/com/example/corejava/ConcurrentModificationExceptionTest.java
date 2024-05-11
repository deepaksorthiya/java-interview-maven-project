package com.example.corejava;

// Java program to show
// ConcurrentModificationException

import java.util.ArrayList;

public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {

        ArrayList<String> arr
                = new ArrayList<>();

        arr.add("One");
        arr.add("Two");
        arr.add("Three");
        arr.add("Four");


        for (String s : arr) {
            System.out.println(s);
            // ConcurrentModificationException
            // is raised here as an element
            // is added during the iteration
            System.out.println("Trying to add an element in between iteration");
            arr.add("Five");
        }
    }
}
