package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapComputeIfAbsent {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println(map);

        String s1 = map.computeIfAbsent(10, i -> i + " + TEN");
        String s2 = map.computeIfAbsent(1, i -> i + " + TEN");

        System.out.println("S1 = " + s1);
        System.out.println("S2 = " + s2);
        System.out.println(map);
    }
}
