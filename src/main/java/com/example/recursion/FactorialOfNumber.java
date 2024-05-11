package com.example.recursion;

public class FactorialOfNumber {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is :: " + findFactorial(n));
    }

    public static int findFactorial(int n) {
        if (n <= 0) {
            return 1;
        }
        int x = findFactorial(n - 1);
        return n * x;
    }
}
