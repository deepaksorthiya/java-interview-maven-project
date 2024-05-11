package com.example.arrayds;

/**
 * Java Program to Find first and last positions of an element in a sorted array
 * <a href="https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/">GFG Link</a> </a>
 */
public class FirstAndLastOccurrenceOfElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int element = 5;
        int firstIndex = findFirstAndLastIndex(arr, 0, arr.length - 1, element, true);
        int lastIndex = findFirstAndLastIndex(arr, 0, arr.length - 1, element, false);
        System.out.println(element + " Element First Occurrence Index :: " + firstIndex);
        System.out.println(element + " Element Last Occurrence Index :: " + lastIndex);
    }

    public static int findFirstAndLastIndex(int[] arr, int l, int r, int element, boolean searchFirst) {
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == element) {
                result = mid;
                if (searchFirst) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else if (element > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
