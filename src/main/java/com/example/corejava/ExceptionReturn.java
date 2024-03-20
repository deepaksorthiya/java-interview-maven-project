package com.example.corejava;

public class ExceptionReturn {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int i = 1;
        try {
            int x = 1 / 0;
            i = 2;
            return i;
        } catch (Exception e) {
            i = 3;
            System.out.println("Exception");
            return i;
        } finally {
            i = 4;
            System.out.println("Finally");
            return i;
        }
    }
}
