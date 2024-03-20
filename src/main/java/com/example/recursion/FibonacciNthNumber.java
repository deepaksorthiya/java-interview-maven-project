package com.example.recursion;

public class FibonacciNthNumber {

    public static void main(String[] args) {
        int ans = findNthFibonacciNumber(6);
        System.out.println(ans);
    }

    public static int findNthFibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }
        int i = findNthFibonacciNumber(n - 1);
        int j = findNthFibonacciNumber(n - 2);
        int sum = i + j;
        //System.out.println("Sum ::" + sum);
        return sum;
    }
}
