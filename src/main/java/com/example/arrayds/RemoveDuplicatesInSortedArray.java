package com.example.arrayds;

import java.util.Arrays;

/**
 * Java Program to Remove duplicates from sorted array <br>
 * <a href="https://www.geeksforgeeks.org/remove-duplicates-sorted-array/">GFG Link</a>
 */
public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        System.out.println("Original Array :: " + Arrays.toString(arr));
        int j = removeDuplicate(arr);
        // Print updated array
        for (int i = 0; i < j; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Modified Array :: " + Arrays.toString(arr));
    }

    public static int removeDuplicate(int arr[]) {
        int n = arr.length;
        if (n == 0 || n == 1)
            return n;

        // To store index of next unique element
        int j = 0;

        // If current element is not equal to next
        // element then store that current element
        // Just maintaining another updated index i.e. j
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n - 1];
        return j;
    }
}
