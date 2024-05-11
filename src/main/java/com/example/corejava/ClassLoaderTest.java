package com.example.corejava;

public class ClassLoaderTest {

    public static void main(String[] args) {

        System.out.println("class loader for java.util.HashMap: "
                + java.util.HashMap.class.getClassLoader());

        System.out.println("class loader for java.sql.Connection : "
                + java.sql.Connection.class.getClassLoader());

        System.out.println("class loader for java.net.http.HttpClient : "
                + java.net.http.HttpClient.class
                .getClassLoader());

        System.out.println("class loader for this class: "
                + ClassLoaderTest.class.getClassLoader());

        System.out.println("class loader for GarbageCollectorTest class: "
                + com.example.corejava.GarbageCollectorTest.class.getClassLoader());
    }
}
/**
 * OUTPUT
 * class loader for java.util.HashMap: null
 * class loader for java.sql.Connection : jdk.internal.loader.ClassLoaders$PlatformClassLoader@3feba861
 * class loader for java.net.http.HttpClient : jdk.internal.loader.ClassLoaders$PlatformClassLoader@3feba861
 * class loader for this class: jdk.internal.loader.ClassLoaders$AppClassLoader@76ed5528
 * class loader for GarbageCollectorTest class: jdk.internal.loader.ClassLoaders$AppClassLoader@76ed5528
 */
