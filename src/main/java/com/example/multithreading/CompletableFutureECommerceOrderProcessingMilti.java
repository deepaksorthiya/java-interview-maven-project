package com.example.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureECommerceOrderProcessingMilti {
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

    private static void processOrder(int orderId, ExecutorService executorService) {
        CompletableFuture<Void> orderValidation = CompletableFuture.runAsync(() -> {
            simulateDelay(1000);
            System.out.println(Thread.currentThread() + " OrderID ::  " + orderId + "✅ Order validated");
        }, executorService);
        CompletableFuture<Void> paymentProcessing = CompletableFuture.runAsync(() -> {
            simulateDelay(1500);
            System.out.println(Thread.currentThread() + " OrderID ::  " + orderId + "💰 Payment processed");
        }, executorService);
        CompletableFuture<Void> inventoryUpdate = CompletableFuture.runAsync(() -> {
            simulateDelay(1200);
            System.out.println(Thread.currentThread() + " OrderID ::  " + orderId + "📦 Inventory updated");
        }, executorService);
        CompletableFuture<Void> confirmationEmail = CompletableFuture.runAsync(() -> {
            simulateDelay(500);
            System.out.println(Thread.currentThread() + " OrderID ::  " + orderId + "📧 Confirmation email sent");
        }, executorService);
        // Wait for all tasks to complete
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(orderValidation, paymentProcessing, inventoryUpdate, confirmationEmail);

        allTasks.join();
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