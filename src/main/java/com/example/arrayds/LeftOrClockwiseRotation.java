package com.example.arrayds;

import java.util.Arrays;

/**
 * Java implementation of Print left rotation of array in O(n) time and O(1) space <br>
 * <a href=https://www.geeksforgeeks.org/print-left-rotation-array/>GFG Link</a>
 */
public class LeftOrClockwiseRotation {
    // Function for k times left rotation
    public static void leftRotate(int[] arr, int k) {
        // if k>arr.length,k%arr.length will bring k back to range
        k %= arr.length;
        // Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Reverse the remaining n-k elements
        reverseArray(arr, k, arr.length - 1);

        // Reverse the entire array
        reverseArray(arr, 0, arr.length - 1);

        // Print the rotated array from start position
        String result = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", " ");
        System.out.println(result);
    }

    // Helper function to reverse a section of an array from start to end (inclusive)
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int k = 2;

        // Function Call
        leftRotate(arr, k);
    }
}

