package com.example.stringdsa;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountAllCharactersInString {

    public static void main(String[] args) {
        String s = "string data to count each character";
        findCountOfChars1(s);
        findCountOfChars2(s);
    }

    public static void findCountOfChars1(String s) {
        Map<String, Long> map = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .filter(str -> str.trim().length() > 0)
                .collect(Collectors
                        .groupingBy(str -> str,
                                LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
    }

    public static void findCountOfChars2(String s) {
        Map<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
    }

}
