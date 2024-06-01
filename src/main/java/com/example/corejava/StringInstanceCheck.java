package com.example.corejava;

public class StringInstanceCheck {

    public static void main(String[] args) {
        String str = null;
        if (str instanceof String) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
//output False
