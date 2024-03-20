package com.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectLevelLock {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ObjectLevelLock obj1 = new ObjectLevelLock();
        //ObjectLevelLock obj2 = new ObjectLevelLock();

        new Thread(() -> obj1.m1()).start();
        new Thread(() -> obj1.m1()).start();
    }

    public void m1() {
        try {
            lock.lock();
            System.out.println("Started : " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Ended : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
