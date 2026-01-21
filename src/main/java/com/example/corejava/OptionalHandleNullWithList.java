package com.example.corejava;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalHandleNullWithList {

    public static void main() {
        List<Integer> list = List.of(1, 2, 3);
        //List<Integer> list = null;
        Integer sum = Optional
                .ofNullable(list) // handle null list
                .orElse(Collections.emptyList()) // if list is null then return empty list
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
