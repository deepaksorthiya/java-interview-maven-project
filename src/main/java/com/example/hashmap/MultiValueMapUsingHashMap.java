package com.example.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MultiValueMapUsingHashMap {
    public static void main(String[] args) {
        Map<Integer, Set<String>> map = new HashMap<>();

        put(map, 1, "one");
        put(map, 2, "two");
        put(map, 2, "three");

        System.out.println(map);
    }

    private static void put(Map<Integer, Set<String>> map, Integer key, String value) {
        map.computeIfAbsent(key, _ -> new HashSet<>()).add(value);
    }
}
