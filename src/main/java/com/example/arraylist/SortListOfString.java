package com.example.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListOfString {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("B");
        list.add("A");
        list.add("ABCD");
        list.add("AB");
        list.add("A");
        list.add("bcd");

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
    }
}
/**
 * OUTPUT
 * [a, B, A, ABCD, AB, A, bcd]
 * [A, A, AB, ABCD, B, a, bcd]
 * [A, A, a, AB, ABCD, B, bcd]
 */
