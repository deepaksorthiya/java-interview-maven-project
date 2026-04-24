package com.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMapGroupByExample {
    public static void main(String[] args) {
        //@formatter:off
        List<Person> persons = List.of(
                new Person(1, "Alex", 100d, new Department(1, "HR")),
                new Person(2, "Brian", 200d, new Department(1, "HR")),
                new Person(3, "Charles", 900d, new Department(2, "Finance")),
                new Person(4, "David", 200d, new Department(2, "Finance")),
                new Person(5, "Edward", 200d, new Department(2, "Finance")),
                new Person(6, "Frank", 800d, new Department(3, "ADMIN")),
                new Person(7, "George", 900d, new Department(3, "ADMIN")),
                new Person(8, "Alex", 200d, new Department(1, "HR")),
                new Person(9, "Alex", 200d, new Department(1, "HR"))
        );
        //@formatter:on

        Map<?, ?> map = persons
                .stream()
                .collect(Collectors
                        .toMap(k -> k.department().name(), p -> new ArrayList<>(List.of(p.name())), (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        }));
        printMap(map);
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println("#########################################");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :::: " + entry.getValue());
        }
        System.out.println("#########################################");
    }

    private record Person(int id, String name, double salary, Department department) {
    }

    private record Department(int id, String name) {
    }
}
