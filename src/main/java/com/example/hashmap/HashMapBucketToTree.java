package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapBucketToTree {

    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();

        for (int i = 1; i <= 63; i++) {
            map.put(new Employee(i, i + "-value"), i + "-value");
        }
        map.put(new Employee(64, 64 + "-value"), "64-value");
    }

    private static class Employee {
        Integer id;
        String name;

        public Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + "]";
        }

        @Override
        public int hashCode() {
            return 1;
        }

//        @Override
//        public boolean equals(Object obj) {
//            Employee e = (Employee) obj;
//            return this.id == e.id;
//        }
    }
}
