package com.example.systemdesign;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap {

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap cache = new LRUCacheUsingLinkedHashMap(2);
        cache.put(2, 1);
        cache.put(1, 1);
        //System.out.println(cache.get(1));
        cache.put(2, 3);
        //System.out.println(cache.get(2));
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        //System.out.println(cache.get(4));
    }

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCacheUsingLinkedHashMap(int capacity) {
        CAPACITY = capacity;
        map = new CustomLinkedHashMap(capacity);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private class CustomLinkedHashMap extends LinkedHashMap<Integer, Integer> {
        public CustomLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > CAPACITY;
        }
    }
}
