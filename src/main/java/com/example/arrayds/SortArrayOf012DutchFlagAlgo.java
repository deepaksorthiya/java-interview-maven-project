package com.example.arrayds;

import java.util.Arrays;

/**
 * Java Program to Sort an array of 0s, 1s and 2s | Dutch National Flag problem <br>
 * <a href="https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/">GFG Link</a>
 */
public class SortArrayOf012DutchFlagAlgo {

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        System.out.println("Original Array :: " + Arrays.toString(arr));
        // Function Call
        sort012(arr, n);
        System.out.println("Sorted Array :: " + Arrays.toString(arr));
    }

    // Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012(int a[], int n) {
        int lo = 0;
        int hi = n - 1;
        int mid = 0, temp = 0;
        // Iterate till all the elements
        // are sorted
        while (mid <= hi) {
            switch (a[mid]) {
                // If the element is 0
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                // If the element is 1
                case 1:
                    mid++;
                    break;
                // If the element is 2
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
