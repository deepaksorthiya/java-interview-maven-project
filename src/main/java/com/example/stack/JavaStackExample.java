package com.example.stack;

import java.util.Stack;

public class JavaStackExample {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        String p = stack.pop();

        System.out.println(p);

    }
}
