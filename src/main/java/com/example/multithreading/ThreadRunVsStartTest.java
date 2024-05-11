package com.example.multithreading;

public class ThreadRunVsStartTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " RUNNING");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadRunVsStartTest());
        t.run();
        t.run();
        t.start();
    }
}
