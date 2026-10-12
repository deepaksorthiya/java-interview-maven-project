package com.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighestSalaryEmployeeDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                // IT Dept: Normal case with duplicates for the 2nd highest
                new Employee("Alice", "IT", 90000.0),
                new Employee("Bob", "IT", 90000.0), // Tied for 1st
                new Employee("Charlie", "IT", 80000.0), // Tied for 2nd
                new Employee("David", "IT", 80000.0), // Tied for 2nd
                new Employee("Eve", "IT", 70000.0),

                // HR Dept: Edge case - everyone has the same salary (No 2nd highest)
                new Employee("Frank", "HR", 60000.0),
                new Employee("Grace", "HR", 60000.0),

                // Finance Dept: Edge case - only one employee (No 2nd highest)
                new Employee("Heidi", "Finance", 95000.0),

                // Sales Dept: Standard case
                new Employee("Ivan", "Sales", 85000.0),
                new Employee("Judy", "Sales", 75000.0)
        );

        Map<String, List<Employee>> secondHighestByDept = employees.stream()
                // 1. Group by department
                .collect(Collectors.groupingBy(
                        Employee::department,

                        // 2. Process the list of employees in each department
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                deptEmployees -> {
                                    // Find the 2nd highest distinct salary
                                    Optional<Double> secondHighestSalary = deptEmployees.stream()
                                            .map(Employee::salary)
                                            .distinct() // Handle duplicate salaries natively
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1) // Skip the 1st highest
                                            .findFirst();

                                    // If a 2nd highest salary exists, filter the employees who have it
                                    return secondHighestSalary.map(salary ->
                                            deptEmployees.stream()
                                                    .filter(e -> e.salary().equals(salary))
                                                    .collect(Collectors.toList())
                                    ).orElse(Collections.emptyList()); // Return empty if < 2 unique salaries
                                }
                        )
                ));

        // Print the results
        secondHighestByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            if (empList.isEmpty()) {
                System.out.println("  -> No second highest salary found (fewer than 2 unique salaries).");
            } else {
                System.out.println("  -> " + empList);
            }
        });
    }

    private record Employee(
            String name,
            String department,
            Double salary) {
    }
}
