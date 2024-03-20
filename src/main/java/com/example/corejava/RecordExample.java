package com.example.corejava;

public class RecordExample {

    public static void main(String[] args) {
        Person p = new Person(1,"a");
    }

    private record Person(int id, String name) {

    }
}
