package com.example.arrayds;

public class AllSubArraysOfArray {

    public static void main(String[] args) {
        int[] arr = {9, 2, 10, 1};

        printSubArrays(arr);
    }

    public static void printSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // Print subarray between current starting and ending points
                System.out.print("{ ");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println("}");
            }
        }
    }
}
