package com.example.corejava;

public class VariableAssignmentInline {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        if ((a = 3) == b) {
            System.out.println(a);
        } else {
            System.out.println(a + b);
        }
    }
}
//output 13