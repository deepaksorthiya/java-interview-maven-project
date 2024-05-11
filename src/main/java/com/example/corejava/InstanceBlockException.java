package com.example.corejava;

public class InstanceBlockException {

    static {
        System.out.println("Static block");
        //int i= 1/0;
    }

    {
        System.out.println("Instance block");
        //int i= 1/0;
    }

    public InstanceBlockException() {
        System.out.println("Constructor block");
        int i = 1 / 0;
    }

    public static void main(String[] args) {
        System.out.println("Start main ");
        InstanceBlockException mainApp = new InstanceBlockException();
    }
}

/**
 * OUTPUT ::
 * Static block
 * Start main
 * Instance block
 * Constructor block
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
 * at com.example.corejava.InstanceBlockException.<init>(InstanceBlockException.java:17)
 * at com.example.corejava.InstanceBlockException.main(InstanceBlockException.java:22)
 */
