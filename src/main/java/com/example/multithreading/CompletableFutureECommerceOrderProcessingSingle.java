package com.example.multithreading;

import java.util.concurrent.*;

public class CompletableFutureECommerceOrderProcessingSingle {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Started");
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        processOrder(1, executorService);
//        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
//            try {
//                for (int i = 1; i <= 20; i++) {
//                    final int orderId = i;
//                    executor.submit(() -> {
//                        processOrder(orderId, executorService);
//                    });
//                }
//            } finally {
//                shutdownAndAwaitTermination(executor);
//            }
//        }
        System.out.println(Thread.currentThread().getName() + " Finished");
        System.out.println(Thread.currentThread() + "🚀 All Order successfully processed!");
    }

    private static void processOrder(int orderId, ExecutorService executor) {
        CompletableFuture<Void> orderProcessingFlow = CompletableFuture
                .runAsync(() -> {
                    simulateDelay(1000);
                    System.out.println(Thread.currentThread() + " OrderID ::  " + orderId +"✅ Order validated");
                    // throw new RuntimeException("Order validation failed"); // Uncomment to simulate failure
                }, executor)
                .thenRunAsync(() -> {
                    simulateDelay(1500);
                    System.out.println(Thread.currentThread() + " OrderID ::  " + orderId +"💰 Payment processed");
                    // throw new RuntimeException("Payment failed"); // Uncomment to simulate failure
                }, executor)
                .thenRunAsync(() -> {
                    simulateDelay(1200);
                    System.out.println(Thread.currentThread() + " OrderID ::  " + orderId +"📦 Inventory updated");
                    // throw new RuntimeException("Inventory update failed"); // Uncomment to simulate failure
                }, executor)
                .thenRunAsync(() -> {
                    simulateDelay(500);
                    System.out.println(Thread.currentThread() + " OrderID ::  " + orderId +"📧 Confirmation email sent");
                }, executor);

        try {
            orderProcessingFlow.join();
            System.out.println("🚀 Order successfully processed!");
        } catch (CompletionException e) {
            System.out.println("🛑 Order processing aborted due to error: " + e.getCause().getMessage());
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

    private static void simulateDelay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}