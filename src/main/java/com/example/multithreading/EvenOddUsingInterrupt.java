package com.example.multithreading;

public class EvenOddUsingInterrupt {
    public static volatile int counter;

    public static void main(String[] args) throws Exception {
        Thread even = new Thread(new EvenProducer(), "Even");
        Thread odd = new Thread(new OddProducer(), "Odd");
        even.start();
        odd.start();
        while (true) {
            counter++;
            even.interrupt();
            odd.interrupt();
            Thread.sleep(1000L);
        }
    }

    private static class EvenProducer implements Runnable {
        public void run() {
            int oldNum = 0;
            while (true) {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted even thread");
                }
                int num = counter;
                if (num != oldNum && num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName()
                            + " thread produced  " + num);
                    oldNum = num;
                }
            }
        }
    }

    private static class OddProducer implements Runnable {
        public void run() {
            int oldNum = 0;
            while (true) {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted odd thread");
                }
                int num = counter;
                if (oldNum != num && num % 2 == 1) {
                    System.out.println(Thread.currentThread().getName()
                            + " thread produced  " + num);
                    oldNum = num;
                }
            }
        }
    }
}
