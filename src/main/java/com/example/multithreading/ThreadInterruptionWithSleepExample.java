package com.example.multithreading;

public class ThreadInterruptionWithSleepExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " RUNNING.");
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " RUNNING.");
                doSleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + " COMPLETED.");
        });

        thread.start();
        doSleep(3000);
        thread.interrupt();
        thread.join();
        System.out.println(Thread.currentThread().getName() + " FINISHED.");
    }

    private static void doSleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " INTERRUPTED.");
            Thread.currentThread().interrupt();
        }
    }
}
