package com.example.multithreading;

import java.util.concurrent.*;

public class CallableFutureThreadExecutionInOrder {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a fixed thread pool with 3 threads

        for (int i = 1; i <= 10; i++) {
            Future<Integer> future = executor.submit(new NumberPrinter(i));
            try {
                future.get(); // Wait for task to complete before submitting the next task
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown(); // Shutdown the executor
    }

    private record NumberPrinter(int num) implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + ": " + num);
            return num;
        }
    }
}
