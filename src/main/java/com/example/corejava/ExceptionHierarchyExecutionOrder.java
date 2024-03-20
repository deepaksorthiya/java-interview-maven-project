package com.example.corejava;

import java.io.FileNotFoundException;

public class ExceptionHierarchyExecutionOrder {

    static class Parent {

        public Parent() {
            System.out.println("I am parent class constructor.");
        }

        public void print() throws NullPointerException {
            System.out.println("I am parent print()");
        }
    }


    static class Child extends Parent {

        public Child() {
            super();
            System.out.println("I am child class constructor.");
        }

        public void print() throws RuntimeException {
            System.out.println("I am child print()");
        }
    }

    public static void main(String[] args) {

        Parent p = new Child();
        p.print();

    }
}
