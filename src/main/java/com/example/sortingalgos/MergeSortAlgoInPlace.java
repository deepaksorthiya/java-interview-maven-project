package com.example.sortingalgos;

/**
 * Java Program to Sort Array using in place merge sort
 * <a href="https://www.geeksforgeeks.org/in-place-merge-sort-set-2/">GFG Link</a>
 */
public class MergeSortAlgoInPlace {

    // Recursive function to split the array
    // into two subarrays and sort them
    public static void mergeSortUtil(int[] arr, int left, int right) {
        // Handle the base case
        if (right - left <= 1) {
            return;
        }

        // Otherwise, find the middle index
        int mid = left + (right - left) / 2;

        // Recursively sort the left subarray
        mergeSortUtil(arr, left, mid);

        // Recursively sort the right subarray
        mergeSortUtil(arr, mid, right);

        // Merge the two sorted arrays
        merge(arr, left, mid, right);
    }

    // Function to merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        // Create a temporary array to store the merged subarray
        int[] temp = new int[right - left];

        // Initialize indices for the left and right subarrays
        int i = left;
        int j = mid;
        int k = 0;

        // Merge the two subarrays
        while (i < mid && j < right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy the remaining elements from the left subarray
        while (i < mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements from the right subarray
        while (j < right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged subarray back to the original array
        for (i = left, k = 0; i < right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // Function to sort the array using merge sort
    public static void mergeSort(int[] arr) {
        // Recursive function to sort the array
        mergeSortUtil(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 2, 1, 6, 7};

        mergeSort(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }
}

