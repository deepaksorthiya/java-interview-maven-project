package com.example.corejava;

import java.util.HashMap;

public class RecordExample {

    public static void main(String[] args) {
        Person p1 = new Person(1, "a");
        Person p2 = new Person(1, "a");

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(p1, p1.id);
        map.put(p2, p2.id);
        System.out.println(map);
        System.out.println("p1.equals(p2) :: " + (p1.equals(p2)));
        System.out.println("p1 == p2 :: " + (p1 == p2));
    }

    private record Person(int id, String name) {

    }
}
