package com.example.corejava;

/**
 * https://www.geeksforgeeks.org/classloader-in-java/
 */

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

        System.out.println("class loader for com.sun.net.httpserver.Authenticatorclass: "
                + com.sun.net.httpserver.Authenticator.class.getClassLoader());

        System.out.println("class loader for jdk.net.ExtendedSocketOptions: "
                + jdk.net.ExtendedSocketOptions.class.getClassLoader());
    }
}
/**
 * OUTPUT
 * class loader for java.util.HashMap: null
 * class loader for java.sql.Connection : jdk.internal.loader.ClassLoaders$PlatformClassLoader@1d81eb93
 * class loader for java.net.http.HttpClient : jdk.internal.loader.ClassLoaders$PlatformClassLoader@1d81eb93
 * class loader for this class: jdk.internal.loader.ClassLoaders$AppClassLoader@5a07e868
 * class loader for GarbageCollectorTest class: jdk.internal.loader.ClassLoaders$AppClassLoader@5a07e868
 * class loader for com.sun.net.httpserver.Authenticatorclass: jdk.internal.loader.ClassLoaders$PlatformClassLoader@1d81eb93
 * class loader for jdk.net.ExtendedSocketOptions: null
 */
