package com.example.hashmap;

import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
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
