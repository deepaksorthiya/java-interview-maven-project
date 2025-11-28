package com.example.arrayds;

import java.util.HashMap;
import java.util.Map;

/**
 * Length of Longest Subarray With Sum K <br>
 * <a href="https://www.geeksforgeeks.org/dsa/longest-sub-array-sum-k/">GFG Link</a>
 */
public class LengthOfLongestSubarrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    // Function to find longest sub-array having sum k
    static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];

            // Check if the entire prefix sums to k
            if (prefSum == k)
                res = i + 1;

                // If prefixSum - k exists in the map then there exist such
                // subarray from (index of previous prefix + 1) to i.
            else {
                int key = prefSum - k;
                if (mp.containsKey(key))
                    res = Math.max(res, i - mp.get(key));
            }

            // Store only first occurrence index of prefSum
            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }
}

/**
 * OUTPUT :
 * 6
 */