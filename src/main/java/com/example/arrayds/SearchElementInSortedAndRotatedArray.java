package com.example.arrayds;


/**
 * Java program to search an element in a sorted and pivoted or rotated array <br>
 * <a href=https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/>GFG Link</a>
 */
public class SearchElementInSortedAndRotatedArray {

    // main function
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int x = 3;
        int result = binarySearchIterative(arr, 0, n - 1, x);
        printResult(result);
        int result2 = binarySearchRecursive(arr, 0, n - 1, x);
        printResult(result2);
    }

    private static void printResult(int result) {
        if (result == -1) {
            System.out.println(
                    "Element is not present in array");
        } else {
            System.out.println(
                    "Element is present at index " + result);
        }
    }

    public static int binarySearchIterative(int arr[], int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            /* If arr[l...mid] first subarray is sorted */
            if (arr[left] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
                if (key >= arr[left] && key <= arr[mid]) {
                    right = mid - 1;
                } else {
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
                    left = mid + 1;
                }
            } else {
                 /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
                if (key >= arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    public static int binarySearchRecursive(int arr[], int l, int h, int key) {
        if (l > h) return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key) return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid]) return binarySearchRecursive(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return binarySearchRecursive(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[h]) {
            return binarySearchRecursive(arr, mid + 1, h, key);
        }

        return binarySearchRecursive(arr, l, mid - 1, key);
    }
}
