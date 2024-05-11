package com.example.hashmap;

import java.util.WeakHashMap;

/**
 * A WeakHashMap in Java is a special type of Map where the keys are stored as weak references.
 * This means that if a key is no longer strongly referenced elsewhere, the garbage collector (GC) can automatically remove that entry from the map when GC runs.
 */
public class WeakHashMapExample {

    public static void main(String[] args) {

        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object key1 = new Object();  // Strong reference
        Object key2 = new Object();
        weakMap.put(key1, "Value1");
        weakMap.put(key2, "Value2");

        System.out.println("Before GC: " + weakMap);
        key2 = null;  // Remove strong reference to key2
        System.gc();   // Suggest GC to run (not guaranteed)

        // Allow time for GC to possibly run
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After GC: " + weakMap);
    }
}

/**
 * Before GC: {java.lang.Object@10f87f48=Value1, java.lang.Object@b4c966a=Value2}
 * After GC: {java.lang.Object@10f87f48=Value1}
 */
