package com.example.corejava;

public class VariableAssignmentInline {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        if ((a = 3) == b) {
            System.out.println(a);
        } else {
            System.out.println("a = " + a);
            System.out.println("sum = " + (a + b));
        }
    }
}
/**
 * OUTPUT ::
 * a = 3
 * sum = 13
 */