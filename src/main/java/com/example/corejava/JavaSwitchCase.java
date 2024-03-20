package com.example.corejava;

public class JavaSwitchCase {

    public static void main(String[] args) {

        int x = 10;
        String s = "";

        switch (x) {
            case 10:
                s += 100;
            case 20:
                s += 20;
            case 50:
                s += 50;
            case 40:
                s += 40;
                break;
            default:
                s += "default";

        }
        System.out.println(s);
    }
}
