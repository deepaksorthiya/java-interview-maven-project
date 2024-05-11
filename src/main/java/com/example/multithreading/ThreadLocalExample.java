package com.example.multithreading;

/**
 * @see ScopeValueExample
 */
public class ThreadLocalExample {

    public static ThreadLocal<String> CONTEXT = ThreadLocal.withInitial(() -> "DEFAULT");
    //public static InheritableThreadLocal<String> CONTEXT = new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException {

        Thread parentThread = new Thread(() -> {

            CONTEXT.set("TestValue");
            insideParentThread_1();

            Thread childThread = new Thread(() -> {
                insideChildThread();
            });

            childThread.start();
            insideParentThread_2();
        });

        parentThread.start();
    }

    static void insideParentThread_1() {
        System.out.println("ThreadLocal Value in insideParentThread_1(): " + CONTEXT.get());
    }

    static void insideParentThread_2() {
        System.out.println("ThreadLocal Value in insideParentThread_2(): " + CONTEXT.get());
    }

    static void insideChildThread() {
        System.out.println("ThreadLocal Value in insideChildThread(): " + CONTEXT.get());
    }

}

/**
 * OUTPUT ::
 * ThreadLocal Value in insideParentThread_1(): TestValue
 * ThreadLocal Value in insideParentThread_2(): TestValue
 * ThreadLocal Value in insideChildThread(): DEFAULT
 */
