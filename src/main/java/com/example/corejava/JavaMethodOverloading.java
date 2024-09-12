package com.example.corejava;

public class JavaMethodOverloading {
    public static void main(String[] args) {
        //String o = null;
        Object o = null;
        //int o = 1;
        //Integer o = 1;
        overload(o);
    }

    private static void overload(Object o) {
        System.out.println("I am overloadObject(Object o) :: " + o);
    }

    private static void overload(String s) {
        System.out.println("I am overloadString(String s) :: " + s);
    }

    private static void overload(Integer i) {
        System.out.println("I am overloadInteger(Integer i) :: " + i);
    }

    private static void overload(int i) {
        System.out.println("I am overloadInt(int i) :: " + i);
    }
}
