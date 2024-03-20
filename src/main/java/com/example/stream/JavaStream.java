package com.example.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {

    public static void main(String[] args) {
        String[] arr = {"d2", "a2", "b1", "b3", "c"};
        List<String> list = Stream.of(arr)
                .limit(2).collect(Collectors.toList());
        System.out.println(list);

    }
}