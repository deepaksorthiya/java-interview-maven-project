package com.example.arrayds;

/**
 * Java implementation of Print the Maximum Subarray Sum in O(n) time and O(1) space <br>
 * <a href=https://www.geeksforgeeks.org/print-the-maximum-subarray-sum/>GFG Link</a>
 */
public class MaximumSubArraySumKadaneAlgo {

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
        // Initialize currMax and globalMax
        // with first value of nums
        int currMax = arr[0], globalMax = arr[0];
        // Initialize endIndex startIndex,globalStartIndex
        int endIndex = 0;
        int startIndex = 0, globalMaxStartIndex = 0;

        // Iterate for all the elements of the array
        for (int i = 1; i < length; ++i) {

            // Update currMax and startIndex
            int sum = arr[i] + currMax;
            if (arr[i] > sum) {
                currMax = arr[i];
                startIndex = i; // update the new startIndex
            }

            // Update currMax
            else if (arr[i] < sum) {
                currMax = sum;
            }

            // Update globalMax and globalMaxStartIndex
            if (currMax > globalMax) {
                globalMax = currMax;
                endIndex = i;
                globalMaxStartIndex = startIndex;
            }
        }

        // Printing the elements of subarray with max sum
        for (int i = globalMaxStartIndex; i <= endIndex;
             ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Maximum Sub Array Sum : " + globalMax);
        System.out.println("Start  Index: " + globalMaxStartIndex);
        System.out.println("End Index  : " + endIndex);
    }
}

/**
 * OUTPUT ::
 * 4 -1 -2 1 5
 * Maximum Sub Array Sum : 7
 * Start  Index: 2
 * End Index  : 6
 */
