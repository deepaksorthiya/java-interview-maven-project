package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMerge {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");


        String s1 = map.merge(1, "merge", (str1, str2) -> {
            System.out.println("Old Value = " + str1 + "  New Value = " + str2);
            return str1 + str2;
        });

        String s2 = map.merge(10, "TEN", (str1, str2) -> {
            System.out.println("Old Value = " + str1 + "  New Value = " + str2);
            return str1 + str2;
        });

        System.out.println("S1 = " + s1);
        System.out.println("S2 = " + s2);
        System.out.println(map);
    }
}
