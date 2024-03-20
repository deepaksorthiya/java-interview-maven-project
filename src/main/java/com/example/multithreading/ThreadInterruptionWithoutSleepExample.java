package com.example.multithreading;

public class ThreadInterruptionWithoutSleepExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " RUNNING.");
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " RUNNING.");
            }
            System.out.println(Thread.currentThread().getName() + " COMPLETED.");
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println(Thread.currentThread().getName() + " FINISHED.");
    }
}
