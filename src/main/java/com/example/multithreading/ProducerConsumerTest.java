package com.example.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


/**
 * Simple Java Program to test Producer Consumer Design Pattern
 * using  wait, notify and notifyAll() methods
 *
 * @author CodePumpkin
 */
public class ProducerConsumerTest {

    public static void main(String[] args) throws InterruptedException {


        final Queue sharedQ = new LinkedList<Integer>();

        Thread consumerThread = new Thread(new Consumer(sharedQ, 4), "CONSUMER");
        Thread producerThread = new Thread(new Producer(sharedQ, 4), "PRODUCER");

        producerThread.start();
        consumerThread.start();

        producerThread.join();

    }

    private static /**
     * Producer Thread will keep producing values for Consumer.
     * <p>
     * It will use wait() method when Queue is full and
     * use notify() method to send notification to Consumer Thread.
     *
     * @author CodePumpkin
     */
    class Producer implements Runnable {
        private final Queue<Integer> sharedQ;
        private final int maxSize;

        public Producer(Queue sharedQ, int maxSize) {
            this.sharedQ = sharedQ;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {

            while (true) {
                synchronized (sharedQ) {
                    doSleep();
                    while (sharedQ.size() == maxSize) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " => Queue is full");
                            sharedQ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    Random random = new Random();
                    int number = random.nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " Producing value " + number);
                    sharedQ.add(number);
                    sharedQ.notify();

                }

            }
        }

        private void doSleep() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static /**
     * Consumer Thread will consumer values form shared queue.
     * <p>
     * It will use wait() method to wait if queue is empty.
     * <p>
     * It will also use notify method to send notification
     * to producer thread after consuming values from queue.
     *
     * @author CodePumpkin
     */
    class Consumer implements Runnable {
        private final Queue<Integer> sharedQ;
        private final int maxSize;

        public Consumer(Queue sharedQ, int maxSize) {
            this.sharedQ = sharedQ;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (sharedQ) {
                    doSleep();
                    while (sharedQ.isEmpty()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " Que is Empty");
                            sharedQ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int number = sharedQ.poll();
                    System.out.println(Thread.currentThread().getName() + " removing Element " + number);
                    sharedQ.notify();

                }
            }
        }

        private void doSleep() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}