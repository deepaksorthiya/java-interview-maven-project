package com.example.corejava;

public class IncrementDecrementOperator {

    public static void main(String[] args) {
        int i = 0;
        int j = i++ + ++i;
        System.out.println(j);
    }
}
// output 2
