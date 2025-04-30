package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceWithProperShutDownAndAwaitTermination {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Started");
        // Create a fixed thread pool with 3 threads
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            try {
                for (int i = 1; i <= 20; i++) {
                    executor.submit(() -> {
                        int millis = (int) (Math.random() * 1000);
                        sleep(millis);
                        System.out.println(Thread.currentThread() + ": " + " SLEEP: " + millis);
                    });
                }
            } finally {
                shutdownAndAwaitTermination(executor);
            }
        }
        System.out.println(Thread.currentThread().getName() + " Finished");
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " :: Exception: " + e.getMessage());
        }
    }

    private static void shutdownAndAwaitTermination(ExecutorService pool) {
        // Disable new tasks from being submitted
        pool.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks forcefully
                pool.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

}
