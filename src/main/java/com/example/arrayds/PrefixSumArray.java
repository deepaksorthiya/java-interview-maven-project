package com.example.arrayds;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java Program to Prefix Sum Array – Implementation and Applications in Competitive Programming <br>
 * <a href="https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/">GFG Link</a>
 */
public class PrefixSumArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        ArrayList<Integer> prefixSum = findPrefixSum(arr);
        System.out.println("Prefix Sum Array: " + prefixSum);
        System.out.println("##############################");
        int[] arr2 = {3, 4, 8, 1, 6, 5};
        System.out.println("Original Array: " + Arrays.toString(arr2));
        inPlacePrefixSum(arr2);
        System.out.println("Prefix Sum Array: " + Arrays.toString(arr2));
        int i = 1, j = 4;
        System.out.println("Sum between indexes " + i + " and " + j + " is " + findSumBetweenIndexes(arr2, i, j));
    }

    public static void inPlacePrefixSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
    }

    /**
     * To find the sum of the subarray from index i to j
     *
     * @param arr2 input array
     * @param i    starting index
     * @param j    ending index
     * @return sum
     */
    public static int findSumBetweenIndexes(int[] arr2, int i, int j) {
        return arr2[j] - arr2[i - 1];
    }

    // Function to find the prefix sum array
    public static ArrayList<Integer> findPrefixSum(int[] arr) {
        int n = arr.length;

        // to store the prefix sum
        ArrayList<Integer> prefixSum = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            prefixSum.add(0);
        }

        // initialize the first element
        prefixSum.set(0, arr[0]);

        // Adding present element with previous element
        for (int i = 1; i < n; i++) {
            prefixSum.set(i, prefixSum.get(i - 1) + arr[i]);
        }

        return prefixSum;
    }


}

/**
 * OUTPUT :
 * Original Array: [1, 2, 3, 4, 5]
 * Prefix Sum Array: [1, 3, 6, 10, 15]
 * ##############################
 * Original Array: [3, 4, 8, 1, 6, 5]
 * Prefix Sum Array: [3, 7, 15, 16, 22, 27]
 * Sum between indexes 1 and 4 is 19
 */
