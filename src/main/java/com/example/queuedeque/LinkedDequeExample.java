package com.example.queuedeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LinkedDequeExample {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offer("one");
        deque.offer("two");
        deque.offer("three");
        deque.offer("four");

        System.out.println(deque);

        String s = deque.pollLast();

        System.out.println(s);
    }
}
