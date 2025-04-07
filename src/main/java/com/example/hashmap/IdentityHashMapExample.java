package com.example.hashmap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {

    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> identityMap = new IdentityHashMap<>();

        String key1 = new String("Java");  // New object
        String key2 = new String("Java");  // Another new object with same value

        hashMap.put(key1, "HashMap Value");
        hashMap.put(key2, "HashMap New Value");  // Overwrites key1 since equals() is used

        identityMap.put(key1, "IdentityMap Value");
        identityMap.put(key2, "IdentityMap New Value");  // Treated as a new entry since == is used

        System.out.println("HashMap: " + hashMap);
        System.out.println("IdentityHashMap: " + identityMap);
    }
}

/**
 * HashMap: {Java=HashMap New Value}
 * IdentityHashMap: {Java=IdentityMap Value, Java=IdentityMap New Value}
 */
