package com.example.sortingalgos;

import java.util.Arrays;

/**
 * Java Program to Bubble Sort <br>
 * <a href="https://www.geeksforgeeks.org/bubble-sort-algorithm/">GFG Link</a>
 */
public class BubbleSortAlgo {

    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = i + 1; j < n; j++) {
                System.out.println(arr[i] + " " + arr[j]);
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            // If no two elements were
            // swapped by inner loop, then break as array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {11, 22, 33};
        int n = arr.length;
        System.out.println("Original array: " + Arrays.toString(arr));
        bubbleSort(arr, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}
