package com.example.binarysearch;

/**
 * Java implementation of recursive Binary Search
 * <a href=https://www.geeksforgeeks.org/binary-search/>GFG Link</a>
 */
public class BinarySearchRecursive {

    // Driver code
    public static void main(String[] args) {
        BinarySearchRecursive ob = new BinarySearchRecursive();
        int[] arr = {2, 3, 4, 10, 40, 50, 60};
        int n = arr.length;
        int x = 40;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index " + result);
    }

    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x) {
                return mid;
            }

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x) {
                int i = binarySearch(arr, l, mid - 1, x);
                return i;
            }

            // Else the element can only be present
            // in right subarray
            int j = binarySearch(arr, mid + 1, r, x);
            return j;
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
