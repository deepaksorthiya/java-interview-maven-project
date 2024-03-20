package com.example.arrayds;

import java.util.Arrays;

/**
 * Java implementation of Array Reverse in O(n) time and O(1) space <br>
 * <a href=https://www.geeksforgeeks.org/program-to-reverse-an-array/>GFG Link</a>
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 3};
        System.out.println(Arrays.toString(arr));
        // Function Call
        reverseArray(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int length) {
        int i = 0;
        int j = length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
