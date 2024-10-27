package com.example.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreadUsingExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadFactory factory = Thread.ofVirtual().name("VIRTUAL-0-WORKER-", 0L).factory();

        try (ExecutorService e = Executors.newThreadPerTaskExecutor(factory)) {
            for (int i = 0; i < 1000; i++) {
                final int t = i;
                e.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + " TASK: " + t);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {

                    }
                });
            }
        }
    }
}
