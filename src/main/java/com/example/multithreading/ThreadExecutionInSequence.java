package com.example.multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadExecutionInSequence {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting ..." + Thread.currentThread().getName());

        Thread thread0 = new Thread(new Worker(null));
        Thread thread1 = new Thread(new Worker(thread0));
        Thread thread2 = new Thread(new Worker(thread1));
        Thread thread3 = new Thread(new Worker(thread2));

        thread3.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        thread1.start();
        Thread.sleep(100);
        thread0.start();
        Thread.sleep(100);

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();


        System.out.println("Finished ..." + Thread.currentThread().getName());
    }

    private record Worker(Thread thread) implements Runnable {

        @Override
        public void run() {
            System.out.println("Starting ..." + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                if (thread != null) {
                    System.out.println("Going to join  ..." + thread.getName());
                    Thread.sleep(100);
                    thread.join();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Finished to join  ..." + thread.getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println("Starting ..." + Thread.currentThread().getName());
            try {
                int min = 1000;
                int max = 2000;
                int timeout = ThreadLocalRandom.current().nextInt(min, max);
                System.out.println("Sleeping ..." + timeout + " " + Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished ..." + Thread.currentThread().getName());
        }
    }
}
