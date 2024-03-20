package com.example.corejava;

public class ClassHierarchyExecutionOrder {

    static class Parent {

        static {
            System.out.println("I am parent class static block.");
        }

        {
            System.out.println("I am parent class instance block.");
        }

        public Parent() {
            System.out.println("I am parent class constructor.");
        }

        public void print() {
            System.out.println("I am parent print()");
        }
    }


    static class Child extends Parent {

        static {
            System.out.println("I am child class static block.");
        }

        {
            System.out.println("I am child class instance block.");
        }

        public Child() {
            super();
            System.out.println("I am child class constructor.");
        }

        public void print() {
            System.out.println("I am child print()");
        }
    }

    public static void main(String[] args) {

        Parent p = new Child();
        p.print();

    }
}
