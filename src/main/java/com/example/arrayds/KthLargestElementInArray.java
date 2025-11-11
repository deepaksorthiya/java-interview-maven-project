package com.example.arrayds;

import java.util.PriorityQueue;

/**
 * Java implementation of Kth Largest Element in an Array. <br>
 * <a href=https://www.geeksforgeeks.org/dsa/kth-largest-element-in-an-array/>GFG Link</a>
 */
public class KthLargestElementInArray {

    public static void main() {
        int[] arr = {12, 3, 5, 7, 19};
        int K = 3;
        System.out.println(K + " Largest Element Is :: " + findKthLargest(arr, K));
    }

    public static int findKthLargest(int[] nums, int k) {
        // 1. Create a min-heap.
        // By default, PriorityQueue is a min-heap in Java.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 2. Iterate through the array
        for (int num : nums) {
            // 3. Add the current element
            minHeap.add(num);

            // 4. If heap size is greater than k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 5. The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}