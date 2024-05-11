package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsExecutionInSequenceThreadPoolExecuters {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Task task = new Task();
        for (int i = 1; i <= 18; i++) {
            executor.execute(task);
        }

        shutdownAndAwaitTermination(executor);
    }

    static void shutdownAndAwaitTermination(ExecutorService pool) {
        // Disable new tasks from being submitted
        pool.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks forcefully
                pool.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    private static class Task implements Runnable {

        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private volatile int id = 1;

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("Start Thread : " + Thread.currentThread().getName() + " ::  Thread ID : " + Thread.currentThread().threadId());
                String tname = Thread.currentThread().getName();
                tname = tname.replace("pool-1-thread-", "");
                int tid = Integer.parseInt(tname);
                while (this.id != tid) {
                    condition.await();
                }
                id++;
                if (id >= 6) {
                    this.id = 1;
                }
                //Thread.sleep(1000);
                System.out.println("Thread Number : " + tid);

                System.out.println("Finished Thread : " + Thread.currentThread().getName() + " ::  Thread ID : " + Thread.currentThread().threadId());
                condition.signalAll();

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
