package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsServiceWithInterrupt {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            executor.submit(() -> {
                doWork(1);
            });
            stopExecutors(executor);
        }
    }

    private static void stopExecutors(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    private static void doWork(int j) {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
            doSleep();
            System.out.println("Hello j = " + j + " " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
        }
    }

    private static void doSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
