package com.example.corejava;

// Java program to show
// ConcurrentModificationException

import java.util.ArrayList;

public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {

        // Creating an object of ArrayList Object
        ArrayList<String> arr
                = new ArrayList<>();

        arr.add("One");
        arr.add("Two");
        arr.add("Three");
        arr.add("Four");


        // Printing the elements
        System.out.println(
                "ArrayList: ");

        for (String s : arr) {

            System.out.print(s
                    + ", ");

            // ConcurrentModificationException
            // is raised here as an element
            // is added during the iteration
            System.out.println(
                    """
                                    Trying to add\
                                      an element in \
                                     between iteration
                            """);
            arr.add("Five");
        }
    }
}
