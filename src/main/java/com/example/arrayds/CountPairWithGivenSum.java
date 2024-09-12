package com.example.arrayds;

import java.util.HashMap;

/**
 * Java implementation of simple method to find count of
 * pairs with given sum.. <br>
 * <a href=https://www.geeksforgeeks.org/count-pairs-with-given-sum/>GFG Link</a>
 */
public class CountPairWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5};
        int n = arr.length;
        int target = 6;
        System.out.print("Count of pairs is "
                + getPairsCount(arr, n, target));
    }

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    public static int getPairsCount(int arr[], int n, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Iterate through each element in the array
        for (int num : arr) {
            int complement = target - num;

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                count += map.get(complement);
                System.out.println("Pair ::" + count + " ==> (" + complement + " , " + num + ")");
            }

            // Update the count of the current element in
            // the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
/**
 * OUTPUT
 * Pair ::1 ==> (1 , 5)
 * Pair ::2 ==> (7 , -1)
 * Pair ::3 ==> (1 , 5)
 * Count of pairs is 3
 */
