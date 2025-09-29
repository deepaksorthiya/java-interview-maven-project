package com.example.corejava;

public class StringBuilderMutableTest2 {

    static void test(StringBuilder sb) {
        sb.append("Mom");
        // sb is local to test fun no effect to original s
        sb = new StringBuilder("Dad");
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("Son");
        test(s);
        System.out.println(s);
    }
}

/**
 * OUTPUT ::
 * SonMom
 */
