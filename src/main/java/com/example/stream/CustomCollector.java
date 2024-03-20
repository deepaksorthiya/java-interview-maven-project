package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {

    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<>(Arrays.asList("5", "4", "a", "5", "4", "5"));
        Collector<String, ?, List<String>> toArrList = Collector.of(ArrayList::new, (strings, e) -> strings.add(e),
                (left, right) -> {
                    left.addAll(right);
                    return left;
                });

        List<String> list = ls.stream().collect(toArrList);
        System.out.println(list);
    }
}
