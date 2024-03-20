package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamRuntimeExceptionHandling01 {

    public static void main(String[] args) {

        ArrayList<String> ls = new ArrayList<>(Arrays.asList("5", "4", "a", "5", "4", "5"));
        Map<Integer, Long> map = ls.stream().map(getFunction(Integer::parseInt)).filter(Objects::nonNull).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

    }

    private static <R, T> Function<R, T> getFunction(Function<R, T> function) {
        return R -> {
            try {
                return function.apply(R);
            } catch (NumberFormatException e) {
                System.out.println("Exception :: " + e);
                return null;
            }
        };
    }
}