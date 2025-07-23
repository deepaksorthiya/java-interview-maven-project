package com.example.sortingalgos;

/**
 * Java Program to Count Sort <br>
 * <a href="https://www.geeksforgeeks.org/counting-sort/">GFG Link</a>
 */
public class CountingSortAlgo {

    public static void main(String[] args) {
        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
        int[] outputArray = countSort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
    }

    public static int[] countSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }

        int[] countArray = new int[M + 1];

        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]] = countArray[inputArray[i]] + 1;
        }

        for (int i = 1; i <= M; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]] = countArray[inputArray[i]] - 1;
        }
        return outputArray;
    }
}
