package com.example.corejava;

import java.util.Optional;

public class OptionalClassTest {

    public static void main(String[] args) {
        String s = "gffdgfd";
        //Optional<String> optional = Optional.of(null); // throws NullPointerException
        Optional<String> optional = Optional.ofNullable(s);
        String s1 = optional.orElse("DULL");
        System.out.println(s1);

    }
}
