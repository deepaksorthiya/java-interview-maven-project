package com.example.multithreading;

public class VirtualThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("virtual-0-worker-", 0);
        Runnable task = () -> System.out.println("Thread Name : " + Thread.currentThread().getName() + " :: Thread ID: " + Thread.currentThread().threadId());

        // name "virtual-0-worker-0"
        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " terminated");

        // name "virtual-0-worker-1"
        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " terminated");
    }
}
