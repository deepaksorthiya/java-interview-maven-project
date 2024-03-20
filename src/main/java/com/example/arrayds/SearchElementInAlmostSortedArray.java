package com.example.arrayds;


/**
 * Java implementation of Search in an almost sorted array <br>
 * <a href=https://www.geeksforgeeks.org/search-almost-sorted-array/>GFG Link</a>
 */
public class SearchElementInAlmostSortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
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

    //iterative approach
    public static int binarySearchIterative(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // If the element is present at
            // one of the middle 3 positions
            if (x == arr[mid]) {
                return mid;
            }
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x) {
                r = mid - 2;
            } else {
                // Else the element can only be present
                // in right subarray
                l = mid + 2;
            }
        }
        return -1;
    }

    // A recursive binary search based function.
    // It returns index of x in given array
    // arr[l..r] is present, otherwise -1
    public static int binarySearchRecursive(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at
            // one of the middle 3 positions
            if (arr[mid] == x)
                return mid;
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchRecursive(arr, l, mid - 2, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchRecursive(arr, mid + 2, r, x);
        }

        // We reach here when element is
        // not present in array
        return -1;
    }


}
