package com.example.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadLeader {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        Leader lead = new Leader(queue, 5);
        Follower foll = new Follower(queue, 5);
        foll.start();
        lead.start();
        foll.join();
        lead.join();
    }

    private static class Leader extends Thread {
        private final BlockingQueue<Integer> queue;
        private final int num;

        Leader(BlockingQueue<Integer> queue, int num) {
            this.queue = queue;
            this.num = num;
        }

        public void run() {
            for (int i = 1; i <= num; i++) {
                System.out.println("Leader is printing " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.offer(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Follower extends Thread {
        private final BlockingQueue<Integer> queue;
        private final int num;

        Follower(BlockingQueue<Integer> queue, int num) {
            this.queue = queue;
            this.num = num;
        }

        public void run() {
            for (int i = 0; i < num; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("Follower is printing " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}