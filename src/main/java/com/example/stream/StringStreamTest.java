package com.example.stream;

import java.util.stream.Collectors;

public class StringStreamTest {

    public static void main(String[] args) {
        String s = "welcome";
        String s1 = s.chars().mapToObj(c -> (char) c).distinct().map(String::valueOf).collect(Collectors.joining());
        System.out.println(s1);
    }
}
