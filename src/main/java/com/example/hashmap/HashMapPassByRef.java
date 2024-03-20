package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapPassByRef {
    public static void main(String... args) {

        Map<StringBuilder, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("TEST");
        map.put(sb, 1);
        System.out.println(map);
        changeSb(sb);
        System.out.println(map);
    }

    private static void changeSb(StringBuilder sb) {
        sb.append(1);
    }

}
