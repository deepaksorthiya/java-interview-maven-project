package com.example.corejava;

public class ClassHierarchyConstructorOrder {

    static class Parent {

        public Parent() {
            System.out.println("I am parent class default() constructor.");
        }
//
//        public Parent(int j) {
//            System.out.println("I am parent class constructor.");
//        }

        public void print() {
            System.out.println("I am parent print()");
        }
    }


    static class Child extends Parent {
//        public Child() {
//            super();
//            System.out.println("I am child class constructor.");
//        }

        public Child(int i) {
            //super();
            System.out.println("I am child class constructor.");
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
