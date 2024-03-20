package com.example.arrayds;

/**
 * <a href=https://www.geeksforgeeks.org/trapping-rain-water/>GFG Link</a>
 */
public class WaterTrapping01 {

    public static int maxWater(int[] arr, int n) {

        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        int n = arr.length;

        System.out.println("Max water trap: " + maxWater(arr, n));
    }
}
