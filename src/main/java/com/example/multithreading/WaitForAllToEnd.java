package com.example.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitForAllToEnd {

    public static void main(String[] args) throws InterruptedException {
        final int total_threads = 4;
        CountDownLatch countDownLatch = new CountDownLatch(total_threads);
        ExecutorService executor = Executors.newFixedThreadPool(total_threads);
        for (int i = 0; i < total_threads; i++) {
            executor.execute(parallelWork(1000, countDownLatch));
        }
        //countDownLatch.await();
        System.out.println("Exit");
        try{
            executor.shutdown();
            while (!executor.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Not yet. Still waiting for termination");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private static Runnable parallelWork(long sleepMillis, CountDownLatch countDownLatch) {
        return () -> {
            System.out.println("I am Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                // Do Something
            }
            //countDownLatch.countDown();
        };
    }
}
