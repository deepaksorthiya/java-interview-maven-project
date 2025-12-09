package com.example.arrayds;

/**
 * JAVA Code for Find Second-largest element in an array <br>
 * <a href=https://www.geeksforgeeks.org/find-second-largest-element-array/>GFG Link</a>
 */
public class SecondMaxElementInArray {

    /* Driver program to test above function */
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int n = arr.length;
        print2largest(arr, n);
    }

    /* Function to print the second-largest
    elements */
    public static void print2largest(int[] arr,
                                     int arr_size) {
        int i, first, second;

        /* There should be at least two elements */
        if (arr == null || arr_size < 2) {
            throw new IllegalArgumentException("Invalid Input");
        }

        first = arr[0];
        second = Integer.MIN_VALUE;
        for (i = 1; i < arr_size; i++) {
            /* If current element is greater than
            first then update both first and second */
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
               second then update second  */
            else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("There is no second largest"
                               + " element");
        } else {
            System.out.println("The second largest element"
                               + " is " + second);
        }
    }
}

