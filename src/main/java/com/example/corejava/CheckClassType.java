package com.example.corejava;

public class CheckClassType {

    public static void main(String[] args) {
        String s = "HELLO";
        System.out.println(s.getClass().getSimpleName());

        Integer i = 99;
        System.out.println(i.getClass().getSimpleName());

        Tomcat t = new Tomcat();
        System.out.println(t.getClass().getSimpleName());
    }

    private static class Tomcat {

    }

}

/**
 * OUTPUT::
 * String
 * Integer
 * Tomcat
 */
