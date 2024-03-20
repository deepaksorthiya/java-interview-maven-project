package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayUsingRecursion { // Main function call
    public static void main(String[] args) {
        ArrayList arr = new ArrayList(
                Arrays.asList(5, 1, 0, 2)
        );
        arr = sort(arr);
        System.out.println(arr);

    }

    // Actual work start's from here
    public static ArrayList sort(ArrayList<Integer> arr) { // sort function
        // Base Condition
        if (arr.size() == 1) {
            return arr;
        }
        // Hypothesis
        int temp = arr.get(arr.size() - 1); // getting 2 out
        arr.remove(arr.size() - 1); // removing it from array
        sort(arr); // sorting the array from [5,1,0] -> [0,1,5]

        insert(arr, temp);
        return arr;
    }

    public static ArrayList insert(ArrayList<Integer> arr, int temp) { // insert function
        // Base Condition
        if (arr.size() == 0 || temp >= arr.get(arr.size() - 1)) { // checking if let say we have 6 in temp & 6 is greater then 5
            arr.add(temp); // we will simply add it into our array
            return arr; // and return it
        }
        // Hypothesis
        int val = arr.get(arr.size() - 1); // getting 5 out
        arr.remove(arr.size() - 1); // removing 5 from array -> [0,1]
        insert(arr, temp); // insrting 2 to [0,1] which becomes -> [0,1,2]

        // Induction
        arr.add(val); // adding 5 to [0,1,2] which becomes -> [0,1,2,5]
        return arr;
    }
}
