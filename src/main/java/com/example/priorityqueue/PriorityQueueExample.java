package com.example.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.offer(5);
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(0);
        priorityQueue.offer(4);


        while (!priorityQueue.isEmpty()) {
            int poll = priorityQueue.poll();
            System.out.println(poll);
        }
        System.out.println(priorityQueue);


    }
}