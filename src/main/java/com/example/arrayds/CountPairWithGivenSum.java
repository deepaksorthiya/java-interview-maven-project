package com.example.arrayds;

import java.util.HashMap;

/**
 * Java implementation of simple method to find count of
 * pairs with given sum.. <br>
 * <a href=https://www.geeksforgeeks.org/count-pairs-with-given-sum/>GFG Link</a>
 */
public class CountPairWithGivenSum {

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    public static int getPairsCount(int arr[], int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], 1);
            }
        }
        return count;
    }

    // Driver function to test the above function
    public static void main(String[] args) {
        int arr[] = {1, 3, 3, 0};
        int n = arr.length;
        int sum = 6;
        System.out.print("Count of pairs is "
                + getPairsCount(arr, n, sum));
    }
}
