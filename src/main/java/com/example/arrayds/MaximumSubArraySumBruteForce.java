package com.example.arrayds;

/**
 * Java implementation of Print the Maximum Subarray Sum in O(n^2) time and O(1) space <br>
 * <a href=https://www.geeksforgeeks.org/print-the-maximum-subarray-sum/>GFG Link</a>
 */
public class MaximumSubArraySumBruteForce {

    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        //int[] arr = {-2, -3, -1};
        //int[] arr = {5, 4, -1, 7, 8};
        //int[] arr = {1, 5, -3};
        //int[] arr = {1, -5, -3};
        //int[] arr = {4, -1, -2, 1, 5};
        findMaxSum(arr, arr.length);

    }

    public static void findMaxSum(int[] arr, int length) {
        int maxSum = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            // Inner loop for ending point of subarray
            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];
                // Update res if currSum is greater than res
                if (currSum > maxSum) {
                    startIndex = i;
                    endIndex = j;
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum Sub Array Sum: " + maxSum);
        System.out.println("Start Index: " + startIndex);
        System.out.println("End Index: " + endIndex);
    }
}

/**
 * OUTPUT ::
 * Maximum Sub Array Sum: 7
 * Start Index: 2
 * End Index: 6
 */
