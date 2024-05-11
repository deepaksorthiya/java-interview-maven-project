package com.example.hashmap;

import java.util.TreeSet;

/**
 * TreeSet internally user TreeMap
 *
 * @see TreeSet
 * @see java.util.TreeMap
 */
public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(3);

        treeSet.forEach(System.out::println);

        treeSet.remove(8);

        treeSet.forEach(System.out::println);

    }
}
