package com.example.arrayds;

import java.util.LinkedHashSet;

/**
 * Java Program to Remove duplicates from unsorted array using Set data structure <br>
 * <a href="https://www.geeksforgeeks.org/remove-duplicates-from-unsorted-array-using-set-data-structure/">GFG Link</a> </a>
 */
public class RemoveDuplicatesInUnSortedArray {

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 2, 3, 9, 8, 6, 6};

        removeDuplicate(arr);
    }

    public static void removeDuplicate(Integer[] arr) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (Integer i : arr) {
            boolean add = linkedHashSet.add(i);
            if (!add) {
                linkedHashSet.remove(i);
            }
        }
        System.out.println(linkedHashSet);
    }
}
