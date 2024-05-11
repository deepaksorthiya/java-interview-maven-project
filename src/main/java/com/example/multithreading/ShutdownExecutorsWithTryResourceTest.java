package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownExecutorsWithTryResourceTest {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            executor.submit(() -> {
                doWork(1);
            });
        }
    }

    private static void doWork(int j) {
        String threadName = Thread.currentThread().getName();
        doSleep();
        System.out.println("Hello j = " + j + " " + threadName);
    }

    private static void doSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
