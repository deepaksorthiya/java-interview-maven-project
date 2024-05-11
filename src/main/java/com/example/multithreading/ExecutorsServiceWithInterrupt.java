package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsServiceWithInterrupt {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executor.submit(() -> {
                    try {
                        doWork(finalI);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " Interrupted");
                        //throw new RuntimeException(e);
                    }
                });
            }
            shutdownAndAwaitTermination(executor);
        }
    }

    public static void shutdownAndAwaitTermination(ExecutorService pool) {
        System.out.println("attempt to shutdown executor");
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(7, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(7, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    private static void doWork(int i) throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState()+ " Value : " + i);
            doSleep();
        }
    }

    private static void doSleep() throws InterruptedException {
        //try {
        Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //System.out.println(Thread.currentThread().getName() + " Interrupted");
        //Thread.currentThread().interrupt();
        //}
    }
}
