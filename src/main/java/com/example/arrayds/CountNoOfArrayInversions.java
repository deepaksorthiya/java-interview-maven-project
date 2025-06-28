package com.example.arrayds;


/**
 * Java Program to Count Number Of Inversions
 * <a href="https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/">GFG Link</a>
 */
public class CountNoOfArrayInversions {

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int inversions = mergeSortAndCountInversions(arr, 0, arr.length - 1);
        System.out.println("Number of inversions: " + inversions);
    }

    // Function to count the number of inversions
    // during the merge process
    public static int mergeSortAndCountInversions(int[] arr, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            invCount += mergeSortAndCountInversions(arr, left, mid);
            invCount += mergeSortAndCountInversions(arr, mid + 1, right);
            invCount += merge(arr, left, mid, right);
        }
        return invCount;
    }

    public static int merge(int arr[], int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int invCount = 0;

        // Create temp arrays
        int tempLeft[] = new int[n1];
        int tempRight[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            tempLeft[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            tempRight[j] = arr[mid + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
                invCount += (mid - i + 1); // Count inversions
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
        return invCount;
    }
}

