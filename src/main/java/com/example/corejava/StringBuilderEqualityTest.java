package com.example.corejava;

/**
 * StringBuilder does not override equals. Uses reference equality.
 */
public class StringBuilderEqualityTest {

    public static void main(String[] args) {
        Object o = new StringBuilder("Dad");
        System.out.println(o.equals(new StringBuilder("Dad")));
    }
}

/**
 * OUTPUT ::
 * false
 */
