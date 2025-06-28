package com.example.arrayds;

import java.util.HashMap;

/**
 * Java Program to Count Subarrays having Sum K <br>
 * <a href="https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/">GFG Link</a>
 */
public class CountAllSubArrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2};
        //int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        int sum = 7;
        System.out.println("Count :: " + subarraySum(arr, sum));
    }

    public static int subarraySum(int[] arr, int sum) {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, 1);
        int res = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {

            // Add current element to sum so far.
            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum = currSum - sum;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

}
