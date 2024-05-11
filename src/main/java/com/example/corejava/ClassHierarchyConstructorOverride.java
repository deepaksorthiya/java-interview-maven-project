package com.example.corejava;

public class ClassHierarchyConstructorOverride {

    static class Parent {

//        public Parent() {
//            System.out.println("Parent class default constructor");
//        }

        public Parent(int j) {
            System.out.println("I am parent class Parent(int j) constructor.");
        }

        public void print() {
            System.out.println("I am parent print()");
        }
    }


    static class Child extends Parent {
        // this is must constructor if parent class have explicit constructor of type public Parent(int i){} define and optional
        // if default is define public Parent(){}
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

/**
 * OUTPUT ::
 * I am parent class Parent(int j) constructor.
 * I am child print()
 */
