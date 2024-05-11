package com.example.arraylist;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");

        list.add(4, "97789");

        System.out.println(list);

        list.remove("two");
        list.remove(3);

        System.out.println(list);

        list.sort(null);
        list.removeIf(s -> s.equals("two"));


        System.out.println(list);
    }
}
