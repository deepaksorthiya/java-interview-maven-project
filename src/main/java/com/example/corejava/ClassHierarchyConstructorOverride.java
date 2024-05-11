package com.example.corejava;

public class ClassHierarchyConstructorOverride {

    static class Parent {

        public Parent(int j) {
            System.out.println("I am parent class constructor.");
        }

        public void print() {
            System.out.println("I am parent print()");
        }
    }


    static class Child extends Parent {
        // this is must constructor if parent class have explicit one
        public Child(int j) {
            super(j);
        }

        public void print() {
            System.out.println("I am child print()");
        }
    }

    public static void main(String[] args) {

        Parent p = new Child(1);
        p.print();

    }
}
