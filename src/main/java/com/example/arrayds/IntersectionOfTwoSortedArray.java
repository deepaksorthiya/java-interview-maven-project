package com.example.arrayds;

public class IntersectionOfTwoSortedArray {
    // Merge arr1[0..n1-1] and arr2[0..n2-1]
    // into arr3[0..n1+n2-1]
    public static void intersectionOfTwoSortedArrays(int[] arr1, int[] arr2, int n1,
                                                     int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                System.out.println("Common Element : " + arr1[i]);
                arr3[k++] = arr1[i];
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 7};
        int n1 = arr1.length;

        int[] arr2 = {2, 4, 6, 8, 9};
        int n2 = arr2.length;

        int[] arr3 = new int[n1 + n2];

        intersectionOfTwoSortedArrays(arr1, arr2, n1, n2, arr3);

        System.out.println("Array after merging");
        for (int i = 0; i < n1 + n2; i++)
            System.out.print(arr3[i] + " ");
    }
}
