package com.example.stringdsa;

public class StringJavaManipulation {

    public static void main(String[] args) {
        String str = "      ff gg ggg gfdgfd   ";
        String[] sa = str.stripLeading().split("\\s+");
        System.out.println(sa.length);
        for (String s : sa) {
            System.out.println(s);
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                System.out.println(i);
            }
        }


    }
}
