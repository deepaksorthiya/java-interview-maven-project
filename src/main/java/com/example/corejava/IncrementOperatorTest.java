package com.example.corejava;

public class IncrementOperatorTest {

    public static void main(String[] args) {
        int i = 0;
        int j = 1;

        int k = i++ + j; // same as i+++j
        System.out.println("i = " + i + "  j = " + j + " k = " + k);
    }
}
