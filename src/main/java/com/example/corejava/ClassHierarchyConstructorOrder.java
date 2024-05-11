package com.example.corejava;

public class ClassHierarchyConstructorOrder {

    static class Parent {

        public Parent() {
            System.out.println("I am parent class default() constructor.");
        }

        public Parent(int j) {
            System.out.println("I am parent class Parent(int j) constructor.");
        }

        public void print() {
            System.out.println("I am parent print()");
        }
    }


    static class Child extends Parent {
        public Child() {
            System.out.println("I am child class default() constructor.");
        }

        public Child(int i) {
            System.out.println("I am child class Child(int i) constructor.");
        }

        public void print() {
            System.out.println("I am child print()");
        }
    }

    public static void main(String[] args) {

        Child p = new Child(1);
        p.print();

    }
}
/**
 output :
 I am parent class default() constructor.
 I am child class Child(int i) constructor.
 I am child print()
 */
