package com.example.hashmap;

import java.util.TreeMap;

public class JavaTreeMapExample {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(3, "three");
        treeMap.put(2, "two");

        System.out.println(treeMap);

    }

}
