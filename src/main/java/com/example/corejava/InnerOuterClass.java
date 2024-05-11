package com.example.corejava;

public class InnerOuterClass {

    static int x = 10;

    // int x = 10 // ERROR - Inner class can't access non-static variable because its static, remove static and check
    static class Inner {
        void print() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        InnerOuterClass innerOutClass = new InnerOuterClass();
        //InnerOuterClass.Inner inner = InnerOuterClass.new Inner();
        Inner inner = new Inner();
        inner.print();
    }

}
