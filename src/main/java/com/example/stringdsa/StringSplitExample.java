package com.example.stringdsa;

public class StringSplitExample {

    public static void main(String[] args) {
        String s = "One two       three";
        String[] s1 = s.split("\\s+");

        for (String string : s1) {
            System.out.println(string);
        }

        System.out.println(s1.length);
    }

}
