package com.example.multithreading;

import java.util.concurrent.StructuredTaskScope;

/**
 * @see ThreadLocalExample
 */
public class ScopeValueExample {

    private static final ScopedValue<String> CONTEXT = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException {
        ScopedValue.where(CONTEXT, "DUKE").call(() -> {

//            new Thread(() -> {
//                insideParentThread();
//            }).start();

            try (var scope = StructuredTaskScope.open()) {

                var r1 = scope.fork(() -> insideChildThread1());
                var r2 = scope.fork(() -> insideChildThread2());

                try {
                    scope.join();
                    System.out.println(r1.get());
                    System.out.println(r2.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return "SUCCESS";
        });
    }

    static void insideParentThread() {
        System.out.println(Thread.currentThread() + " ThreadLocal Value in insideParentThread_1(): " + CONTEXT.get());
        System.out.println(Thread.currentThread() + " ThreadLocal Value in insideParentThread_1(): " + CONTEXT.isBound());
    }

    static String insideChildThread1() {
        System.out.println(Thread.currentThread() + " ThreadLocal Value in insideParentThread_2(): " + CONTEXT.get());
        System.out.println(Thread.currentThread() + " ThreadLocal Value in insideParentThread_1(): " + CONTEXT.isBound());
        return null;
    }

    static String insideChildThread2() {
        System.out.println(Thread.currentThread() + " ThreadLocal Value in insideChildThread(): " + CONTEXT.get());
        System.out.println(Thread.currentThread() + " ThreadLocal Value in insideParentThread_1(): " + CONTEXT.isBound());
        return null;
    }
}
