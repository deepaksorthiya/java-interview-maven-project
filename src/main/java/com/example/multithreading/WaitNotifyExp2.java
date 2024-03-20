package com.example.multithreading;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyExp2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ..." + Thread.currentThread().getName());
        final Worker worker = new Worker();
        Thread dbService = new Thread(() -> {
            start();
           // sleepDelay(400);
            worker.doWork();
            //sleepDelay(100);
            System.out.println("DB is UP " + Thread.currentThread().getName());
            finished();
        }, "DB-SERVICE");


        Thread cacheService = new Thread(() -> {
            start();
            //sleepDelay(300);
            worker.doWork();
           // sleepDelay(100);
            System.out.println("Cache is UP " + Thread.currentThread().getName());
            finished();
        }, "CACHE-SERVICE");

        Thread alertService = new Thread(() -> {
            start();
            worker.doWork();
            sleepDelay(200);
            finished();
        }, "ALERT-SERVICE");

        dbService.start();
        cacheService.start();
        alertService.start();

        Thread.sleep(5000);

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Press Enter to start DB");
        scanner.nextLine();  // Read user input
        worker.setDbUp();

        Thread.sleep(5000);
        System.out.println("Press Enter to start Cache");
        scanner.nextLine();  // Read user input
        worker.setCacheUp();

        dbService.join();
        cacheService.join();
        alertService.join();

        System.out.println("Finished ..." + Thread.currentThread().getName());


    }

    public static void sleepDelay(long sleep) {
        try {
            TimeUnit.MILLISECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void start() {
        System.out.println("Started " + Thread.currentThread().getName());
    }

    public static void finished() {
        System.out.println("Finished " + Thread.currentThread().getName());
    }

    private static class Worker {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private volatile boolean isDbUp;
        private volatile boolean isCacheUp;

        public void sleepDelay(long sleepMilliSecs) {
            try {
                TimeUnit.MILLISECONDS.sleep(sleepMilliSecs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void doWork() {
            try {
                sleepDelay(200);
                System.out.println("In doWork() " + Thread.currentThread().getName());
                lock.lock();
                sleepDelay(200);
                System.out.println("Got lock In doWork() " + Thread.currentThread().getName());
                while (!isDbUp) {
                    condition.await();
                }
                sleepDelay(100);
                while (!isCacheUp) {
                    condition.await();
                }
                sleepDelay(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                sleepDelay(200);
                System.out.println("Got Unlocked In doWork() " + Thread.currentThread().getName());
                lock.unlock();
            }
        }

        public void setDbUp() {
            try {
                lock.lock();
                this.isDbUp = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void setCacheUp() {
            try {
                lock.lock();
                this.isCacheUp = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }


    }
}
