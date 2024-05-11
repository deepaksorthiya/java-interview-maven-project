package com.example.arrayds;

import java.util.Arrays;

/**
 * Java Program to Move all zeros to front of array <br>
 * <a href="https://www.geeksforgeeks.org/move-all-zeros-to-front-of-array/">GFG Link</a>
 */
public class MoveAllZerosToFront {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println("Original Array :: " + Arrays.toString(arr));
        moveZerosToFront(arr);
        System.out.println("Modified Array :: " + Arrays.toString(arr));
    }

    public static void moveZerosToFront(int[] arr) {
        int count = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[count--] = arr[i];
            }
        }
        while (count >= 0) {
            arr[count--] = 0;
        }
    }
}
