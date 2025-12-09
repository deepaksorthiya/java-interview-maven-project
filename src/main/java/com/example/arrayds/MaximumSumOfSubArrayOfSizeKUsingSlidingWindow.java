package com.example.arrayds;

/**
 * Maximum sum of a subarray of size k using sliding window technique<br>
 * <a href="https://www.geeksforgeeks.org/dsa/find-maximum-minimum-sum-subarray-size-k/">GFG Link</a>
 */
public class MaximumSumOfSubArrayOfSizeKUsingSlidingWindow {

    static void main() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSubarraySum(arr, k));
    }

    public static int maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return -1;
        }
        int currWindowSum = 0;
        // calculate initial sum of window of size k
        for (int i = 0; i < k; i++) {
            currWindowSum = currWindowSum + nums[i];
        }
        int maxWindowSum = currWindowSum;
        // try to remove start element and add next by sliding the window one by one
        for (int i = k; i < n; i++) {
            int outIdx = i - k;
            int outElement = nums[outIdx];
            int inElement = nums[i];
            currWindowSum = currWindowSum + (inElement - outElement);
            maxWindowSum = Math.max(maxWindowSum, currWindowSum);
        }
        return maxWindowSum;
    }
}
