package com.example.corejava;

public class MethodOverloadingArray {
    public static void method(int... nums) {
        System.out.println("Int varargs");
    }

    public static void method(Integer... nums) {
        System.out.println("Integer varargs");
    }

    public static void main(String[] args) {
        //method(null); // ERROR Ambiguous method call
        //method(1, 2, 3); //ERROR ambiguous method call
        method(new int[]{1, 2, 3});
        method(new Integer[]{1, 2, 3});
    }
}

/**
 * OUTPUT ::
 * Int varargs
 * Integer varargs
 */