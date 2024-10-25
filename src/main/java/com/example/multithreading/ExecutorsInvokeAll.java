package com.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsInvokeAll {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Started");
        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a fixed thread pool with 3 threads
        List<Callable<Integer>> callables = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            final Integer num = i;
            callables.add(() -> {
                sleep((int) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + ": " + num);
                return num;
            });
        }

        List<Future<Integer>> results = executor.invokeAll(callables);

        for (Future<Integer> future : results) {
            try {
                Integer i = future.get();// Wait for task to complete before submitting the next task
                System.out.println(Thread.currentThread().getName() + " === " + i);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        executor.shutdown(); // Shutdown the executor
        System.out.println(Thread.currentThread().getName() + " Finished");
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
