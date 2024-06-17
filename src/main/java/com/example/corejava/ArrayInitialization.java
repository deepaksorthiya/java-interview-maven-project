package com.example.corejava;

import java.util.Arrays;

public class ArrayInitialization {

    public static void main(String[] args) {

        Integer h[] = new Integer[2];
        //below also works
        //int h[] = new int[2];
        h[0] = new Integer(7);
        h[1] = 99;
        System.out.println(h.length);
        System.out.println(Arrays.toString(h));
    }
}
/**
  output:
  2
 [7, 99]
 */
