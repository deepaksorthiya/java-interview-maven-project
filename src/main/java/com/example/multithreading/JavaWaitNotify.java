package com.example.multithreading;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " started." + " : State : " + Thread.currentThread().getState());

        Work w = new Work();
        Thread t1 = new Thread((() -> w.producer()));
        Thread t2 = new Thread((() -> w.consumer()));

        t2.start();
        Thread.sleep(3000);
        t1.start();

        t1.join();
        t2.join();

        System.out.println(Thread.currentThread().getName() + " finished." + " : State : " + Thread.currentThread().getState());

    }

    private static class Work {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        private volatile boolean flag;

        public void producer() {
            try {
                sleep(200);
                System.out.println(Thread.currentThread().getName() + " enter in produce()." + " : State : " + Thread.currentThread().getState());
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " got lock." + " : State : " + Thread.currentThread().getState());
                System.out.println(Thread.currentThread().getName() + " going for wait." + " : State : " + Thread.currentThread().getState());
                sleep(500);
                while (!flag) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + " had waited." + " : State : " + Thread.currentThread().getState());
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                sleep(200);
                System.out.println(Thread.currentThread().getName() + " released lock." + " : State : " + Thread.currentThread().getState());
                lock.unlock();
            }
        }

        public void consumer() {
            try {
                sleep(200);
                System.out.println(Thread.currentThread().getName() + " enter in consume()." + " : State : " + Thread.currentThread().getState());
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " got lock." + " : State : " + Thread.currentThread().getState());
                System.out.println(Thread.currentThread().getName() + " go for signal. waiting for return key" + " : State : " + Thread.currentThread().getState());
                Scanner scanner = new Scanner(System.in);  // Create a Scanner object
                scanner.nextLine();  // Read user input
                flag = true;
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + " signaled." + " : State : " + Thread.currentThread().getState());

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                sleep(200);
                System.out.println(Thread.currentThread().getName() + " released lock." + " : State : " + Thread.currentThread().getState());
                lock.unlock();
            }
        }

        public void sleep(int delayMillSec) {
            try {
                TimeUnit.MILLISECONDS.sleep(delayMillSec);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
