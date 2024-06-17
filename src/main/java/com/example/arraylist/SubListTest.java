package com.example.arraylist;

import java.util.ArrayList;

public class SubListTest {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");

        System.out.println(list);
        ArrayList<String> llist = new ArrayList<>(list.subList(1, 3));
        System.out.println(llist);
    }
}
