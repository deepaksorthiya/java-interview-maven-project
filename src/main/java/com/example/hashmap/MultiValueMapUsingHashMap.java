package com.example.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MultiValueMapUsingHashMap {
    public static void main(String[] args) {
        Map<Integer, Set<String>> map = new HashMap<>();


        map.computeIfAbsent(1, key -> new HashSet<>()).add("one");
        map.computeIfAbsent(2, key -> new HashSet<>()).add("two");
        map.computeIfAbsent(2, key -> new HashSet<>()).add("three");

        System.out.println(map);
    }
}
