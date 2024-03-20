package com.example.corejava;

public class StaticMethodTest {

    public static void main(String[] args) {
        StaticMethodTest staticMethodTest = null;
        staticMethodTest.print();
        StaticMethodTest.print();
    }

    public static void print() {
        System.out.println("Hello");
    }

}
