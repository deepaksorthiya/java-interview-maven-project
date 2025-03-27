package com.example.stringdsa;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"a", "ac", "b"};
        //String[] strs = {"abc", "ac", "ab"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int min = Math.min(first.length(), last.length());
        for (int i = 0; i < min; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

}
