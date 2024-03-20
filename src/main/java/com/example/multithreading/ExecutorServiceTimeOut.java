package com.example.multithreading;

import java.util.concurrent.*;

public class ExecutorServiceTimeOut {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> submit = service.submit(() -> {
            Thread.sleep(5000);
            return 5;
        });

        try {
            Integer i = submit.get(2000, TimeUnit.MILLISECONDS);
            System.out.println(i);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " + e);
        } catch (ExecutionException e) {
            System.out.println("Execution Exception : " + e);
        } catch (TimeoutException e) {
            System.out.println("Timeout Exception : " + e);
        }
        shutdownAndAwaitTermination(service);
    }

    static void shutdownAndAwaitTermination(ExecutorService pool) {
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
