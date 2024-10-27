package com.example.multithreading;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutExampleWithExceptionHandling {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> f1 = getFut();
        CompletableFuture<Integer> f2 = getFut();
        CompletableFuture<Integer> f3 = getFut();

        CompletableFuture.allOf(f1, f2, f3).join();

        System.out.println("F1  = " + f1.get());
        System.out.println("F2  = " + f2.get());
        System.out.println("F3  = " + f3.get());

        long end = System.currentTimeMillis();
        System.out.println("Time taken : " + (end - start));
    }

    public static CompletableFuture<Integer> getFut() {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + " STARTED.");
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    int v = new Random().nextInt(10) + 1;
                    if (v < 5) {
                        throw new RuntimeException();
                    }
                    return v;
                })
                .handleAsync((value, exception) -> {
                    System.out.println("Value: " + value + " Exception: " + exception);
                    System.out.println(Thread.currentThread().getName() + " FINISHED.");
                    return value;
                });
    }
}

/**
 * OUTPUT
 * Value: 10 Exception: null
 * Value: null Exception: java.util.concurrent.CompletionException: java.lang.RuntimeException
 * Value: null Exception: java.util.concurrent.CompletionException: java.lang.RuntimeException
 * F1  = 10
 * F2  = null
 * F3  = null
 * Time taken : 2030
 */
