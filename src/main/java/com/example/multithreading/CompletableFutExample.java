package com.example.multithreading;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutExample {
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
                    System.out.println(Thread.currentThread().getName() + " FINISHED.");
                    int v = new Random().nextInt(10) + 1;
                    if (v < 5) {
                        throw new RuntimeException();
                    }
                    return v;
                })
                .handleAsync((v, t) -> {
                    System.out.println("Exception===>" + t);
                    System.out.println(v);
                    return v;
                });
    }
}
