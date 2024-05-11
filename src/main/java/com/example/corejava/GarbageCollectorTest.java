package com.example.corejava;

public class GarbageCollectorTest {

    static volatile GarbageCollectorTest t;
    static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        GarbageCollectorTest t1 = new GarbageCollectorTest();
        //making t1 eligible for gc
        t1 = null;
        //calling gc
        System.gc();
        //wait for gc to complete
        Thread.sleep(1000);

        GarbageCollectorTest t2 = new GarbageCollectorTest();
        //making t2 eligible for gc
        t2 = null;
        //calling gc
        System.gc();
        //wait for gc to complete
        Thread.sleep(1000);

        //making t1 eligible for gc
        t = null;
        //calling gc
        System.gc();
        //wait for gc to complete
        Thread.sleep(1000);
        System.out.println("Final Count :: " + count);
    }

    @Override
    protected void finalize() throws Throwable {
        count++;
        t = this;
        System.out.println("Called finalize " + count);
    }
}
