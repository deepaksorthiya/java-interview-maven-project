package com.example.array;

public class JavaArraySecondMax {

    public static void main(String[] args) {
        int[] arr = {100, 100,5, 6, 3, 200,200, 7, 8, 2, 99};
        findSecondMax(arr);
    }

    private static void findSecondMax(int[] arr) {
        int fmax = arr[0];
        int smax = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > fmax) {
                smax = fmax;
                fmax = arr[i];
            }
            if (arr[i] > smax && arr[i] < fmax) {
                smax = arr[i];
            }
        }

        System.out.println(fmax);
        System.out.println(smax);
    }
}
