package com.example.arrayds;

import java.util.HashSet;

/**
 * Java program to check if there exists a pair
 * in array whose sum results in x. <br>
 * <a href=https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/>GFG Link</a>
 */
public class TwoSumElementInArray {

    public static void main(String[] args) {
        int array[] = {1, 4, 45, 6, 10, 8};
        int sum = 16;
        findPairs(array, sum);
    }

    public static void findPairs(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int temp = sum - array[i];

            // checking for condition
            if (set.contains(temp)) {
                System.out.println("Yes");
                return;
            }
            set.add(array[i]);
        }
    }

}
