package com.example.corejava;

public class StaticMethodOverrideTest {

    public static void main(String[] args) {
        Parent p = new Child();
        p.print();
    }

    static class Parent {
        public static void print() {
            System.out.println("I am parent print()");
        }
    }

    static class Child extends Parent {
        public static void print() {
            System.out.println("I am child print()");
        }
    }
}
