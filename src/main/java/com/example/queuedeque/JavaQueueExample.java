package com.example.queuedeque;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        System.out.println(queue);
    }
}
