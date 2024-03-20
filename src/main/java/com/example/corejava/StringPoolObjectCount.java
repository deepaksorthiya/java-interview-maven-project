package com.example.corejava;

import static java.lang.System.identityHashCode;

public class StringPoolObjectCount {

    public static void main(String[] args) {
        String x = new String("abc");
        String y = "abc";

        System.out.printf("x: %d | %d\n", identityHashCode(x), identityHashCode(x.intern()));
        System.out.printf("y: %d | %d\n", identityHashCode(y), identityHashCode(y.intern()));
    }
}
