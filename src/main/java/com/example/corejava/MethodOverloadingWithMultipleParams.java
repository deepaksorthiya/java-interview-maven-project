package com.example.corejava;

public class MethodOverloadingWithMultipleParams {
    public static void main(String[] args) {
        //overload(0, 0); //ERROR Ambiguous method call
        overload(0f, 0L);

        byte b1 = 2;
        byte b2 = 2;
        //overload(b1, b2); //ERROR Ambiguous method call

        short s1 = 198;
        short s2 = 198;

        //overload(s1, s2); //ERROR Ambiguous method call

    }

    private static void overload(double a, double b) {
        System.out.println("I am overload(double a, double b) :: " + "a = " + a + " : b = " + b);
    }

    private static void overload(int a, long b) {
        System.out.println("I am overload(int a, long b) :: " + "a = " + a + " : b = " + b);
    }

    private static void overload(long a, int b) {
        System.out.println("I am overload(long a, int b) :: " + "a = " + a + " : b = " + b);
    }

    private static void overload(long a, long b) {
        System.out.println("I am overload(long a, long b) :: " + "a = " + a + " : b = " + b);
    }
}

/**
 * OUTPUT
 * I am overload(double a, double b) :: a = 0.0 : b = 0.0
 */
