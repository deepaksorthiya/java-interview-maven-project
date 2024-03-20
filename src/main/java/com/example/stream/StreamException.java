package com.example.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamException {

    public static void main(String[] args) {

        ArrayList<String> ls = new ArrayList<>(Arrays.asList("5", "4", "a", "5", "4", "5"));
        Map<Integer, Long> map = ls.stream().map(getFunction(Integer::parseInt)).filter(Objects::nonNull).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

    }

    private static <K, V> Function<K, V> getFunction(Function<K, V> function) {
        return K -> {
            try {
                return function.apply(K);
            } catch (NumberFormatException e) {
                System.out.println("Exception :: " + e);
                return null;
            }
        };
    }
}