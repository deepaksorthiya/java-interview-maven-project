package com.example.corejava;

public class ClassLoaderTest {

    public static void main(String[] args) {

        System.out.println("class loader for HashMap: "
                + java.util.HashMap.class.getClassLoader());

        System.out.println("class loader for Integer: "
                + java.sql.Connection.class.getClassLoader());

        System.out.println("class loader for HttpClient: "
                + java.net.http.HttpClient.class
                .getClassLoader());

        System.out.println("class loader for this class: "
                + ClassLoaderTest.class.getClassLoader());

        System.out.println("class loader for GarbageCollectorTest class: "
                + com.example.corejava.GarbageCollectorTest.class.getClassLoader());
    }
}
