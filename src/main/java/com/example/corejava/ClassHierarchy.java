package com.example.corejava;

public class ClassHierarchy {

    static class Animal {
        public void name() {
            System.out.println("Object is ::" + this.getClass().getName());
        }
    }

    static class Dog extends Animal {

    }

    static class Labrador extends Dog {

    }

    static class Leopard extends Labrador {

    }

    public static void main(String[] args) {
        Animal animal = new Leopard();
        animal.name();
        printValue(animal);
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

/**
 * OUTPUT -- Comment relevant methods to see diff output
 * Object is ::com.example.corejava.ClassHierarchy$Leopard
 * Animal
 */