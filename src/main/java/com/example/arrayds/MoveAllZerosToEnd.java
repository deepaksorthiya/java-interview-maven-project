package com.example.arrayds;

import java.util.Arrays;

/**
 * Java Program to Move all zeros to end of array <br>
 * <a href="https://www.geeksforgeeks.org/move-zeroes-end-array/">GFG Link</a>
 */
public class MoveAllZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println("Original Array :: " + Arrays.toString(arr));
        moveZerosToEnd(arr);
        System.out.println("Modified Array :: " + Arrays.toString(arr));
    }

    public static void moveZerosToEnd(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }
        while (count < arr.length) {
            arr[count++] = 0;
        }
    }
}
