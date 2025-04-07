package com.example.maths;

public class StringToIntegerConvert {

    public static int stringToInteger(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int i = 0;
        while (s.charAt(i) == ' ') {
            if (++i == n) {
                return 0;
            }
        }
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            ++i;
        }
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            if (res > flag || (res == flag && s.charAt(i) > '7')) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(stringToInteger("-042"));
        //System.out.println(stringToInteger("-321"));
        //System.out.println(stringToInteger("342"));
    }
}
