package com.example.arrayds;

/**
 * Java Program to Find Minimum and Maximum Element in array
 * <a href="https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/">GFG Link</a>
 */
public class ArrayMinMax {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 20};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("MAX : " + max + " \nMIN : " + min);
    }
}
