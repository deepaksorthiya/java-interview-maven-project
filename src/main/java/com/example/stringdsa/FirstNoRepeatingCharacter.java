package com.example.stringdsa;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNoRepeatingCharacter {
    static String firstNonRepChar(String s) {
        // code here
        Map<Character, Integer> hashMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> hm : hashMap.entrySet()) {
            if (hm.getValue() == 1) {
                return String.valueOf(hm.getKey());
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(firstNonRepChar(str));
    }
}