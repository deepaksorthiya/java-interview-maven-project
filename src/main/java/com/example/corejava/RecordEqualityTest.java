package com.example.corejava;

public class RecordEqualityTest {
    public static void main(String[] args) {
        Department d1 = new Department(1, "HR");
        Department d2 = new Department(1, "HR");

        Person p1 = new Person(1, "Alex", 100d, d1);
        Person p2 = new Person(1, "Alex", 100d, d2);

        System.out.println(d1.equals(d2));
        System.out.println(p1.equals(p2));
    }

    private record Person(int id, String name, double salary, Department department) {
    }

    private record Department(int id, String name) {
    }
}
