package com.example.multithreading;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompletableFutureListExample {

    public static void main(String[] args) {
        Instant start = Instant.now();
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            try {
                List<String> tasksInput = List.of("Task 1", "Task 2", "Task 3", "Task 4", "Task 5");
                // 1. Submit tasks and collect CompletableFutures into a List
                List<CompletableFuture<String>> futures = tasksInput.stream()
                        .map(input -> CompletableFuture.supplyAsync(() -> processTask(input), executorService))
                        .collect(Collectors.toList());

                // 2. Wait for all futures to complete
                CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

                // Wait for completion (blocking call, use in appropriate context)
                allOf.join();

                // 3. Combine results using join() which is safe after allOf().join()
                List<String> results = futures.stream()
                        .map(CompletableFuture::join) // join() throws unchecked exception, good for use after allOf()
                        .toList();

                System.out.println("All tasks completed. Combined results: " + results);
            } finally {
                shutdownAndAwaitTermination(executorService);
            }
        }
        Instant end = Instant.now();
        System.out.println("Execution time: " + Duration.between(start, end).toMillis());
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

    /**
     * A simulated task that returns a result.
     */
    private static String processTask(String input) {
        try {
            // Simulate some work
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Processed: " + input + " in thread: " + Thread.currentThread().getName();
    }
}