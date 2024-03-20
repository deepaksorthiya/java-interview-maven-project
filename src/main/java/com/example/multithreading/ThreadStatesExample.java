package com.example.multithreading;

import java.util.Scanner;

public class ThreadStatesExample {


    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        System.out.println("L11 :: " + t.getName() + " : State : " + t.getState());
        t.start();
        System.out.println("L13 :: " + t.getName() + " : State : " + t.getState());
        Thread.sleep(2000);
        System.out.println("L15 :: " + t.getName() + " : State : " + t.getState());
        Scanner scanner = new Scanner(System.in);
        System.out.println("L17 :: " + t.getName() + " : State : " + t.getState());
        System.out.println("Press enter to stop");
        scanner.nextLine();
        System.out.println("L20 :: " + t.getName() + " : State : " + t.getState());
        Thread.sleep(2000);
        worker.notifyT();
        System.out.println("L23 :: " + t.getName() + " : State : " + t.getState());
        Thread.sleep(2000);
        System.out.println("L25 :: " + t.getName() + " : State : " + t.getState());
    }

    private static class Worker implements Runnable {
        private final Object lock = new Object();

        @Override
        public void run() {

            try {
                System.out.println("L35 :: " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
                Thread.sleep(3000);
                synchronized (lock) {
                    System.out.println("L38 :: " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
                    lock.wait();
                    System.out.println("L41 :: " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
                }
                System.out.println("L42 :: " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void notifyT() {
            synchronized (lock) {
                System.out.println("L50 :: " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
                lock.notifyAll();
                System.out.println("L52 :: " + Thread.currentThread().getName() + " : State : " + Thread.currentThread().getState());
            }
        }

    }
}
