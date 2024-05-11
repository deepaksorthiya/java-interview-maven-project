package com.example.stringdsa;

public class FirstRepeatingCharacter {
    static String firstRepChar(String s) {
        // code here
        int a[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int idx = ch - 'a';
            if (a[idx] != 0) {
                return Character.toString(ch);
            } else {
                a[idx]++;
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(firstRepChar(str));
    }
}