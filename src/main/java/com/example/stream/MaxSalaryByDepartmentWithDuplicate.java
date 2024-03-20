package com.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxSalaryByDepartmentWithDuplicate {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Department hr = new Department("HR");
        Department it = new Department("IT");

        employees.add(new Employee("John", 50000, hr));
        employees.add(new Employee("Alice", 60000, it));
        employees.add(new Employee("Bob", 55000, hr));
        employees.add(new Employee("Jane", 60000, it));  // Duplicate salary
        employees.add(new Employee("Smith", 52000, it));
        employees.add(new Employee("Joe", 60000, hr));   // Duplicate salary
        employees.add(new Employee("Annabel", 60000, hr));   // Duplicate salary

        Map<Department, List<Employee>> maxSalaryByDepartment = findMaxSalaryByDepartment(employees);

        if (maxSalaryByDepartment.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            printMap(maxSalaryByDepartment);
        }
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println("#########################################");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :::: " + entry.getValue());
        }
        System.out.println("#########################################");
    }

    public static Map<Department, List<Employee>> findMaxSalaryByDepartment(List<Employee> employees) {
        if (employees.isEmpty()) {
            return Collections.emptyMap();
        }
        // Group employees by department
        Map<Department, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));

        // Find max salary for each department
        return employeesByDepartment.entrySet().stream().map(MaxSalaryByDepartmentWithDuplicate::processEmployees).collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
    }

    private static Map.Entry<Department, List<Employee>> processEmployees(Map.Entry<Department, List<Employee>> departmentListEntry) {
        double maxSalary = departmentListEntry.getValue().stream()
                .mapToDouble(Employee::salary)
                .max()
                .orElse(0);
        List<Employee> maxSalaryEmployees = departmentListEntry.getValue().stream()
                .filter(emp -> emp.salary() == maxSalary)
                .collect(Collectors.toList());
        departmentListEntry.setValue(maxSalaryEmployees);
        return departmentListEntry;
    }

    private record Employee(String name, double salary, Department department) {
        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department=" + department +
                    '}';
        }
    }

    private record Department(String name) {
        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}