package com.example.corejava;

public class ClassHierarchyVariableOverride {

    static class Parent {
        protected String name = "PARENT";

        public void print() {
            System.out.println("I am parent print()");
            System.out.println("Parent Name :: " + name);
        }

        public void parentInfo() {
            System.out.println("I am parent parentInfo()" + name);
        }
    }


    static class Child extends Parent {
        protected String name = "CHILD";

        public void print() {
            System.out.println("I am child print()");
            System.out.println("Child Name :: " + this.name);
            System.out.println("Parent Name :: " + super.name);
        }

        public void childInfo() {
            System.out.println("I am child childInfo()");
        }
    }

    public static void main(String[] args) {

        Child child = new Child();

        child.name = "John Doe";
        child.print();
        child.parentInfo();
        //child.childInfo();

        Parent p = new Child();
        //p.childInfo(); //error

        //Child child1 = (Child) new Parent(); // runtime error

    }
}

/**
 * OUTPUT ::
 * I am child print()
 * Child Name :: John Doe
 * Parent Name :: PARENT
 * I am parent parentInfo()PARENT
 */