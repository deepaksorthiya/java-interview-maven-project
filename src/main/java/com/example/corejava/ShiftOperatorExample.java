package com.example.corejava;

public class ShiftOperatorExample {
    public static void main(String[] args) {
        int i = 8 >> 1; // 8/2^1
        int j = 2 << 1; // 2*2^1
        int k = 8 >>> 1; // 8/2^1
        int l = -4 >>> 1;
        int m = -4 >> 1;
        int o = -4 << 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("l = " + l);
        System.out.println("m = " + m);
        System.out.println("o = " + o);
    }
}
/**
 *  output :
 2147483647
 i = 4
 j = 4
 k = 4
 l = 2147483646
 m = -2
 o = -8
 */
