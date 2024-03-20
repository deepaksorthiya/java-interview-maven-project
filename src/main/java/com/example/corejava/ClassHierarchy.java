package com.example.corejava;

public class ClassHierarchy {

    static class Animal {

    }

    static class Dog extends Animal {

    }

    static class Labrador extends Dog {

    }

    static class Leopard extends Labrador {

    }

    public static void main(String[] args) {
        Animal labrador = new Leopard();
        printValue(labrador);
    }

    static void printValue(Animal animal) {
        System.out.println("Animal");
    }

    static void printValue(Dog dog) {
        System.out.println("Dog");
    }

    static void printValue(Leopard leopard) {
        System.out.println("Leopard");
    }

    static void printValue(Object o) {
        System.out.println("Object");
    }

    static void printValue(String s) {
        System.out.println("String");
    }
}