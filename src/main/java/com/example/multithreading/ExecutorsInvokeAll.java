package com.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsInvokeAll {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Started");
        // Create a fixed thread pool with 3 threads
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            List<Callable<Integer>> callables = new ArrayList<>();

            for (int i = 1; i <= 20; i++) {
                final Integer num = i;
                callables.add(() -> {
                    int millis = (int) (Math.random() * 1000);
                    sleep(millis);
                    System.out.println(Thread.currentThread().getName() + ": " + num + " SLEEPED: " + millis);
                    return num;
                });
            }
            try {
                List<Future<Integer>> results = executor.invokeAll(callables);
                for (Future<Integer> future : results) {
                    try {
                        Integer i = future.get();// Wait for task to complete before submitting the next task
                        System.out.println(Thread.currentThread().getName() + " === " + i);
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Finished");
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            } finally {
                shutdownAndAwaitTermination(executor);
            }
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
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
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
