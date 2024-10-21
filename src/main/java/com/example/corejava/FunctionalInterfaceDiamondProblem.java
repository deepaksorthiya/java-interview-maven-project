package com.example.corejava;


public class FunctionalInterfaceDiamondProblem {
    public static void main(String[] args) {
        Test a = new Test();
        a.dm();
        a.print();
    }

    @FunctionalInterface
    private interface A {
        void print();

        default void dm() {
            System.out.println("I am A dm()");
        }
    }

    @FunctionalInterface
    private interface B {
        void print();

        default void dm() {
            System.out.println("I am B dm()");
        }
    }

    private static class Test implements A, B {

        @Override
        public void print() {
            A.super.dm();
        }

        @Override
        public void dm() {
            B.super.dm();
        }
    }
}

/**
 * OUTPUT
 * I am B dm()
 * I am A dm()
 */
