package com.example.corejava;

import java.util.ArrayList;
import java.util.List;

public class RecordImmutabilityTest {
    public static void main(String[] args) {
        List<String> streets = new ArrayList<>();
        streets.add("Street 1");
        streets.add("Street 2");

        Address address = new Address("City", List.copyOf(streets));
        streets.add("Street 3");

        System.out.println(address.streets());
    }

    public record Address(String city, List<String> streets) {
    }
}
