package com.example.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {
    static volatile boolean stopRunning = false;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Thread producer = new Thread(() -> {
            while (!stopRunning) {
                final Random random = new Random();
                int p = random.nextInt(10) + 1;
                try {
                    doSleep(200);
                    blockingQueue.put(p);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " started." + " : State : " + Thread.currentThread().getState() + " : Producing : " + p);
            }
            System.out.println(Thread.currentThread().getName() + " STOPPED." + " : State : " + Thread.currentThread().getState());
        }, "PRODUCER");

        Thread consumer = new Thread(() -> {
            while (!stopRunning) {
                int c = 0;
                try {
                    doSleep(300);
                    c = blockingQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " started." + " : State : " + Thread.currentThread().getState() + " : Consuming : " + c);
            }
            System.out.println(Thread.currentThread().getName() + " STOPPED." + " : State : " + Thread.currentThread().getState());
        }, "CONSUMER");

        producer.start();
        consumer.start();

        Thread.sleep(10000);
        stopRunning = true;

        producer.join();
        consumer.join();
    }

    private static void doSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
