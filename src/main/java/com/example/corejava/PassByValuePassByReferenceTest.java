package com.example.corejava;

public class PassByValuePassByReferenceTest {
    public static void main(String[] args) {
        Language p = new Language();
        p.name = "EJava";
        function1(p);
        System.out.println(p.name);
        function2(p);
        System.out.println(p.name);
    }

    static class Language {
        public String name;
    }

    static void function2(Language p) {
        p.name = "Python";
        System.out.println(p.name);
    }

    static void function1(Language p) {
        p = new Language();
        p.name = "Angular";
        System.out.println(p.name);
    }

}
