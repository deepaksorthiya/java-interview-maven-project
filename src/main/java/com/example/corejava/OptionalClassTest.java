package com.example.corejava;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalClassTest {

    public static void main(String[] args) {
        String s = "gffdgfd";
        //Optional<String> optional = Optional.of(null); // throws NullPointerException
        Optional<String> optional = Optional.ofNullable(s);
        String s1 = optional.orElse("DULL");
        System.out.println(s1);

        List<Integer> list = List.of(1, 2, 3);
        Integer sum = Optional
                .ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
