package com.example.corejava;

public class MethodOverloadingStringVarargs {
    public static void method(String s) {
        System.out.println("String");
    }

    public static void method(String... s) {
        System.out.println("Varargs");
    }

    public static void main(String[] args) {
        method("Hello");
        method("Hello", "World");
        //method(null); // Ambiguous method call
    }
}

/**
 * The method with single String argument is preferred over
 * the method with String... s (varargs).
 * OUTPUT ::
 * String
 * Varargs
 */