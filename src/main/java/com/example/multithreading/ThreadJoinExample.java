package com.example.multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadJoinExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ..." + Thread.currentThread().getName());

        Thread dbService = new Thread(() -> {
            sleepDelay(5000);
        }, "DB-SERVICE");


        Thread cacheService = new Thread(() -> {
            sleepDelay(2000);
        }, "CACHE-SERVICE");

        Thread alertService = new Thread(() -> {
            sleepDelay(1000);
        }, "ALERT-SERVICE");

        alertService.start();
        cacheService.start();
        dbService.start();

        alertService.join();
        cacheService.join();
        dbService.join();

        System.out.println("Finished ..." + Thread.currentThread().getName());


    }

    public static void sleepDelay(long sleep) {
        System.out.println("Starting " + Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Started " + Thread.currentThread().getName());
    }
}
