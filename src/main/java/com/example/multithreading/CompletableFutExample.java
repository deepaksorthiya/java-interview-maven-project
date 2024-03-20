package com.example.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName()+" STARTED.");
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" FINISHED.");
                    return 1;
                }).exceptionally(throwable -> null)
                .handleAsync((v, t) -> {
                    System.out.println("Exception===>" + t);
                    System.out.println(v);
                    return v;
                });
        future.thenAccept((t) -> System.out.println("finished")).get();
    }
}
