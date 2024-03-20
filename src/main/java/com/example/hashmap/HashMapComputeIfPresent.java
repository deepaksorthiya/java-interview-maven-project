package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapComputeIfPresent {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        String s1 = map.computeIfPresent(1, (i, s) -> {
            System.out.println("Old Value = " + s);
            return i + " + " + s;
        });

        String s2 = map.computeIfPresent(10, (i, s) -> {
            System.out.println("Old Value = " + s);
            return i + s1;
        });
        System.out.println("S1 = " + s1);
        System.out.println("S2 = " + s2);
        System.out.println(map);
    }
}
