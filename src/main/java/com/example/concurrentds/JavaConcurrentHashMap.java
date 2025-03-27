package com.example.concurrentds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Refer below article <br>
 * <a href=https://rommansabbir.com/understanding-concurrenthashmap-in-kotlinjava>Understanding Concurrenthashmap Link</a> <br>
 * <a href=https://github.com/openjdk-mirror/jdk7u-jdk/blob/master/src/share/classes/java/util/concurrent/ConcurrentHashMap.java>ConcurrentHashMap Old Source Code Link</a> <br>
 */
public class JavaConcurrentHashMap {
    public static void main(String[] args) {

        ConcurrentHashMap<Employee, Integer> map = new ConcurrentHashMap<>();

        Employee e1 = new Employee(1, "one");
        Employee e2 = new Employee(2, "two");
        Employee e3 = new Employee(3, "three");
        Employee e4 = new Employee(1, "four");
        Employee e5 = new Employee(1, "five");

        map.put(e1, e1.id);
        map.put(e2, e2.id);
        map.put(e3, e3.id);
        map.put(e1, e1.id);
        map.put(e4, e4.id);
        map.put(e5, e4.id);


        int mapGet = map.get(e5);
        System.out.println(mapGet);

        int removedEmp = map.remove(e5);
        System.out.println(removedEmp);

        for (Map.Entry<Employee, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println(map.size());
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
