package com.example.corejava;

public class ShallowCopyTest {

    public static void main(String[] args) {

        Department dept1 = new Department("1", "A", "AVP");
        Employee emp1 = new Employee(111, "John", dept1);
        Employee emp2 = null;

        try {
            // Creating a clone of emp1 and assigning it to emp2
            emp2 = (Employee) emp1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // Printing the designation of 'emp1'
        System.out.println(emp1.dept.designation); // Output : AVP
        // Changing the designation of 'emp2'
        emp2.dept.designation = "Director";
        // This change will be reflected in original Employee 'emp1'
        System.out.println(emp1.dept.designation); // Output : Director
    }

    private static class Department {
        String empId;
        String grade;
        String designation;

        public Department(String empId, String grade, String designation) {
            this.empId = empId;
            this.grade = grade;
            this.designation = designation;
        }
    }

    private static class Employee implements Cloneable {
        int id;
        String name;
        Department dept;

        public Employee(int id, String name, Department dept) {
            this.id = id;
            this.name = name;
            this.dept = dept;
        }

        // Default version of clone() method. It creates shallow copy of an object.

        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}