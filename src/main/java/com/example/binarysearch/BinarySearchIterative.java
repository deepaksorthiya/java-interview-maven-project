package com.example.binarysearch;

/**
 * Java implementation of iterative Binary Search
 * Time Complexity: O(log N) <br>
 * Auxiliary Space: O(1) <br>
 * <a href=https://www.geeksforgeeks.org/binary-search/>GFG Link</a>
 */
public class BinarySearchIterative {

    // Driver code
    public static void main(String[] args) {
        BinarySearchIterative ob = new BinarySearchIterative();
        int[] arr = {2, 3, 4, 10, 40};
        //int[] arr = {2, 3, 4, 10, 40, 12};
        int x = 10;
        //int x = 11;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                               + "index " + result);
    }

    // Returns index of x if it is present in arr[].
    int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) / 2);

            // Check if x is present at mid
            if (arr[m] == x) {
                return m;
            }

            // If x greater than middle element ignore left half
            if (arr[m] < x) {
                l = m + 1;
            }
            // If x is smaller than middle element ignore right half
            else {
                r = m - 1;
            }
        }

        // If we reach here, then element was
        // not present
        return -1;
    }
}

