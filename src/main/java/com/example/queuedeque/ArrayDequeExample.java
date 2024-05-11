package com.example.queuedeque;

import java.util.ArrayDeque;

public class ArrayDequeExample {

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.offer("one");
        deque.offer("two");
        deque.offer("three");
        deque.offer("four");

        System.out.println(deque);

        String s = deque.poll();

        System.out.println(s);
    }
}
