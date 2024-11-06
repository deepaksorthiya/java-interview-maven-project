package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadSynchronization {

    public static void main(String[] args) {

        ThreadFactory factory = Thread.ofVirtual().name("VIRTUAL-0-WORKER-", 0L).factory();
        AtomicInteger count = new AtomicInteger();
        try (ExecutorService e = Executors.newThreadPerTaskExecutor(factory)) {
            try {
                for (int i = 0; i < 1000; i++) {
                    final int t = i;
                    e.submit(() -> {
                        System.out.println(Thread.currentThread().getName() + " TASK: " + t);
                        count.getAndIncrement();
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException ex) {
                            System.err.println(ex);
                        }
                    });
                }
            } finally {
                shutdownAndAwaitTermination(e);
            }

        }
        System.out.println("Count is = " + count.get());
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
