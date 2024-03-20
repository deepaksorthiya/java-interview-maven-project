package com.example.array;

import java.util.ArrayList;

public class JavaArrList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");

        list.remove("two");

        list.sort(null);


        System.out.println(list);
    }
}
