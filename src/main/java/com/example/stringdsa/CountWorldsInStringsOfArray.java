package com.example.stringdsa;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWorldsInStringsOfArray {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names
                .stream()
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println(namesCount);
    }
}
