package com.example.hashmap;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(50);
        set.add(10);
        set.add(30);
        set.add(40);
        set.add(20);

        for (Integer i : set) {
            System.out.println(i);
        }

        boolean b = set.contains(40);
        System.out.println(b);

    }

}
