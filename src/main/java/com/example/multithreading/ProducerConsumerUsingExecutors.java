package com.example.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingExecutors {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        PC pc = new PC();

        for (int i = 0; i < 15; i++) {
            service.execute(() -> {
                try {
                    pc.put();
                    pc.get();
                } catch (InterruptedException e) {
                }
            });
        }
        stopExecutors(service);
    }

    private static void stopExecutors(ExecutorService service) {
        try {
            System.out.println("attempt to shutdown service");
            service.shutdown();
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!service.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            service.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    private static class PC {

        private static final int CAPACITY = 10;
        private final Queue<Integer> queue = new LinkedList<>();
        private final Random theRandom = new Random();
        // lock and condition variables
        private final Lock aLock = new ReentrantLock();
        private final Condition bufferNotFull = aLock.newCondition();
        private final Condition bufferNotEmpty = aLock.newCondition();

        public void put() throws InterruptedException {
            aLock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
                    bufferNotEmpty.await();
                }
                int number = theRandom.nextInt(100);
                boolean isAdded = queue.offer(number);
                if (isAdded) {
                    System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);
                    // signal consumer thread that, buffer has element now
                    System.out.println(Thread.currentThread().getName() + " : Signalling that buffer is no more empty now");
                    bufferNotFull.signalAll();
                }
            } finally {
                aLock.unlock();
            }
        }

        public void get() throws InterruptedException {
            aLock.lock();
            try {
                while (queue.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting");
                    bufferNotFull.await();
                }
                Integer value = queue.poll();
                if (value != null) {
                    System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);
                    // signal producer thread that, buffer may be empty now
                    System.out.println(Thread.currentThread().getName() + " : Signalling that buffer may be empty now");
                    bufferNotEmpty.signalAll();
                }
            } finally {
                aLock.unlock();
            }
        }
    }
}
