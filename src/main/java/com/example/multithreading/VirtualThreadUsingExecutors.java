package com.example.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreadUsingExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadFactory factory = Thread.ofVirtual().name("VIRTUAL-THREAD", 0L).factory();

        try (ExecutorService e = Executors.newThreadPerTaskExecutor(factory)) {
            e.submit(() -> System.out.println(Thread.currentThread().getName()));
            e.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
    }
}
