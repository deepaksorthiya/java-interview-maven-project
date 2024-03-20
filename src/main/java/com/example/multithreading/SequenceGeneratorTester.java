package com.example.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequenceGeneratorTester {
    private static final int NUMBER_OF_THREADS = 3;
    private static final int TOTAL_NUMBERS_IN_SEQ = 10;

    public static void main(String[] args) throws InterruptedException {
        NumbersGenerator numbersGenerator = new NumbersGenerator(NUMBER_OF_THREADS, TOTAL_NUMBERS_IN_SEQ);

        Thread t1 = new Thread(new SequenceGenerator(numbersGenerator, 1), "THREAD-1");
        Thread t2 = new Thread(new SequenceGenerator(numbersGenerator, 2), "THREAD-2");
        Thread t3 = new Thread(new SequenceGenerator(numbersGenerator, 0), "THREAD-3");


        t3.start();
        Thread.sleep(8000);
        t2.start();
        Thread.sleep(9000);
        t1.start();
    }

    private static class SequenceGenerator implements Runnable {

        private final NumbersGenerator numbersGenerator;
        private final int index;

        public SequenceGenerator(NumbersGenerator numbersGenerator, int index) {
            this.numbersGenerator = numbersGenerator;
            this.index = index;
        }

        @Override
        public void run() {
            numbersGenerator.printNumber(this.index);
        }
    }

    private static class NumbersGenerator {
        private int currNumber = 1;
        private final int numOfThreads;
        private final int totalNumbersInSeq;

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public NumbersGenerator(final int numOfThreads, final int totalNumbersInSeq) {
            this.numOfThreads = numOfThreads;
            this.totalNumbersInSeq = totalNumbersInSeq;
        }

        public void printNumber(int index) {
            try {
                System.out.println(Thread.currentThread().getName() + " Entering.");
                sleep(1);
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " acquired lock.");
                sleep(1);
                while (currNumber < totalNumbersInSeq - 1) {
                    while (currNumber % numOfThreads != index) {
                        try {
                            sleep(1);
                            System.out.println(Thread.currentThread().getName() + " going to wait.");
                            sleep(1);
                            condition.await();
                            System.out.println(Thread.currentThread().getName() + " wake up.");
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sleep(1);
                    System.out.println(Thread.currentThread().getName() + " : " + currNumber++);
                    System.out.println(Thread.currentThread().getName() + " going to signal.");
                    sleep(1);
                    condition.signalAll();
                    System.out.println(Thread.currentThread().getName() + " has signal.");
                    sleep(1);
                }
            } finally {
                System.out.println(Thread.currentThread().getName() + " release lock.");
                sleep(1);
                lock.unlock();
            }
        }

        private void sleep(int time) {
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}