package com.example.hashmap;

import java.util.HashMap;

public class HashMapTreeifyThreshold {

    public static void main(String[] args) {
        HashMap<Employee, Integer> map = new HashMap<>();

        Employee e1 = new Employee(1, "one");
        Employee e2 = new Employee(1, "two");
        Employee e3 = new Employee(1, "three");
        Employee e4 = new Employee(1, "four");
        Employee e5 = new Employee(1, "five");
        Employee e6 = new Employee(1, "six");
        Employee e7 = new Employee(1, "seven");
        Employee e8 = new Employee(1, "eight");
        Employee e9 = new Employee(1, "nine");
        Employee e10 = new Employee(1, "ten");
        Employee e11 = new Employee(1, "eleven");
        Employee e12 = new Employee(1, "twelve");
        Employee e13 = new Employee(1, "thirteen");

        map.put(e1, e1.id);
        map.put(e2, e2.id);
        map.put(e3, e3.id);
        map.put(e4, e4.id);
        map.put(e5, e5.id);
        map.put(e6, e6.id);
        map.put(e7, e7.id);
        map.put(e8, e8.id);
        map.put(e9, e9.id);
        map.put(e10, e10.id);
        map.put(e11, e11.id);
        map.put(e12, e12.id);
        map.put(e13, e13.id);

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
            return this.id;
        }

//        @Override
//        public boolean equals(Object obj) {
//            Employee e = (Employee) obj;
//            return this.id == e.id;
//        }
    }

}
