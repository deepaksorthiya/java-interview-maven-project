package com.example.arrayds;

/**
 * Java Program to Count Number Of Rotation of Sorted and Rotated Array
 * <a href="https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/">GFG Link</a> </a>
 */
public class NumberOfRotationsInSortedRotatedArray {

    public static int countRotations(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // If the array is already sorted, the first element will be the minimum
            if (arr[low] <= arr[high])
                return low;

            /*
            for who don't understand modulo parts
            case 1 if mid = 0 or the first index
            for instance arr = [1, 2]
            prev = mid - 1 = -1 which thrown an error because arr[-1] is out of range
            prev = (mid - 1 + n) % n = 1, it prevents an error from negative index

            case 2 if mid = n - 1 or the last index
            such as arr = [2, 3, 1] , assume that mid = 2
            next = mid + 1 = 3, which arr[3] is out of range
            next = (mid + 1) % n = 0, loop index is initialized to the first index, think like a circular array
             */
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;

            // Check if mid is the pivot point
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return mid;
                // If the right half is sorted, pivot should be in the left half
            else if (arr[mid] <= arr[high])
                high = mid - 1;
                // If the left half is sorted, pivot should be in the right half
            else if (arr[mid] >= arr[low])
                low = mid + 1;
        }
        return -1; // Array is not rotated
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int rotations = countRotations(arr);
        System.out.println("The array is rotated " + rotations + " times.");
    }
}

