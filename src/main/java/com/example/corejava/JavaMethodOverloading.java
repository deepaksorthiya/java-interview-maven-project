package com.example.corejava;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class JavaMethodOverloading {
    public static void main(String[] args) {
        String s = null;
        Object o = null;
        int i = 1;
        Integer integer = 1;
        overload(i);
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
