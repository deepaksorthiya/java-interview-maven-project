package com.example.corejava;

public class CheckClassType {

    public static void main(String[] args) {
        String s = "HELLO";
        Class<?> sClass = s.getClass();
        System.out.println(sClass.getClass().getSimpleName());
        Tomcat t = new Tomcat();
        System.out.println(t.getClass().getSimpleName());
    }

    private static class Tomcat {

    }

}

/**
 * OUTPUT::
 * Class
 * Tomcat
 */
