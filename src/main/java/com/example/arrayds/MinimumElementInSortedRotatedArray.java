package com.example.arrayds;

/**
 * Java Program to Find Minimum element in sorted and rotated array <br>
 * <a href="https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/">GFG Link</a> </a>
 */
public class MinimumElementInSortedRotatedArray {
    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3, 4};
        int min = findMinInSortedRotatedArray(arr, 0, arr.length - 1);
        System.out.println("Minimum Element Index :: " + min);
    }

    public static int findMinInSortedRotatedArray(int[] arr, int l, int r) {
        while (l <= r) {
            if (arr[l] <= arr[r]) {
                return l;
            }
            int mid = l + (r - l) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[l] <= arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
