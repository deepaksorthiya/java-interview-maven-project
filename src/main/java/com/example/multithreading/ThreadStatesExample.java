package com.example.multithreading;

import java.util.Scanner;

public class ThreadStatesExample {


    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        System.out.println(t.getName() + " : State : " + t.getState());
        t.start();
        System.out.println(t.getName() + " : State : " + t.getState());
        Thread.sleep(2000);
        System.out.println(t.getName() + " : State : " + t.getState());
        Scanner scanner = new Scanner(System.in);
        System.out.println(t.getName() + " : State : " + t.getState());
        System.out.println("Press enter to stop");
        scanner.nextLine();
        System.out.println(t.getName() + " : State : " + t.getState());
        Thread.sleep(2000);
        worker.notifyT();
        System.out.println(t.getName() + " : State : " + t.getState());
        Thread.sleep(2000);
        System.out.println(t.getName() + " : State : " + t.getState());
    }

    private static class Worker implements Runnable {
        private final Object lock = new Object();

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
                Thread.sleep(1000);
                synchronized (lock) {
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void notifyT() {
            synchronized (lock) {
                lock.notifyAll();
            }
        }

    }
}
