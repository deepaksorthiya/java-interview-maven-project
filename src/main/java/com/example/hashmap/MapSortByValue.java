package com.example.hashmap;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValue {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);


        LinkedHashMap<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, _) -> oldValue, LinkedHashMap::new));
        printMap(sortedMap);
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println("#########################################");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :::: " + entry.getValue());
        }
        System.out.println("#########################################");
    }
}
