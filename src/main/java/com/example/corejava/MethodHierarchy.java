package com.example.corejava;

public class MethodHierarchy {

    public static void main(String[] args) {

        MethodHierarchy mm = new MethodHierarchy();

        Child m = mm.new Child();
    }

    private class Child {
    }

}