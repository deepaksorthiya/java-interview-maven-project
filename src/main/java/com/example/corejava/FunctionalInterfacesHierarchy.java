package com.example.corejava;


public class FunctionalInterfacesHierarchy {


    public static void main(String args[]) {
        FuncTest obj = new FuncTest();
        obj.display();
        System.out.println(obj instanceof Func);
        System.out.println(obj instanceof Interface1);
        System.out.println(obj instanceof Interface2);
    }

    private static class FuncTest extends Func implements Interface1, Interface2 {
        public void display() {
            Interface1.super.display();
            //or,
            Interface2.super.display();
        }
    }

    private static abstract class Func {
        abstract void display();
    }

    private interface Interface1 {
        int num = 100;

        default void display() {
            System.out.println("display method of MyInterface1");
        }
    }

    private interface Interface2 {
        int num = 1000;

        default void display() {
            System.out.println("display method of MyInterface2");
        }
    }
}

/**
 * display method of MyInterface1
 * display method of MyInterface2
 * true
 * true
 * true
 */