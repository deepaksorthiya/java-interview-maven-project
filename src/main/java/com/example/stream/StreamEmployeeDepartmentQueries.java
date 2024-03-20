package com.example.stream;

import lombok.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamEmployeeDepartmentQueries {
    public static void main(String[] args) {

        Department hr = new Department(1, "HR");
        Department development = new Department(2, "Development");
        Department infrastructure = new Department(3, "Infrastructure");


        Employee e1 = new Employee(1, "A", 100.00, 25, "MALE", hr);
        Employee e2 = new Employee(2, "B", 101.00, 26, "FEMALE", hr);

        List<Employee> employees = List.of(e1, e2);

        //Map<String, List<Employee>> collect = employees.stream().distinct().collect(Collectors.groupingBy(Employee::getGender,Collectors.));
        //System.out.println(collect);
        //System.out.println(employees);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    private static class Employee {

        private int id;
        private String name;
        private Double salary;
        private int age;
        private String gender;
        private Department department;

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Employee employee = (Employee) object;
            return id == employee.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    private static class Department {

        private int id;
        private String name;

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Department that = (Department) object;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
