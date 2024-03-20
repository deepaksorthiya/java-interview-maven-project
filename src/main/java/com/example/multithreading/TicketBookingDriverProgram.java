package com.example.multithreading;

public class TicketBookingDriverProgram {

    public static void main(String[] args) {
        CustomLock customLock = new CustomReentrantLock();
        TicketBookingIRCTC myRunnable = new TicketBookingIRCTC(customLock, 3);
        new Thread(myRunnable, "Passenger-1 Nikhil").start();
        new Thread(myRunnable, "Passenger-2 Ranjan").start();
        new Thread(myRunnable, "Passenger-3 Yunus").start();
        new Thread(myRunnable, "Passenger-4 CKM").start();
        new Thread(myRunnable, "Passenger-5 Ritz").start();
    }

    private static class TicketBookingIRCTC implements Runnable {

        int ticketsAvailable; // scarce resource
        CustomLock customLock;

        public TicketBookingIRCTC(CustomLock customLock, int totalTicket) {
            this.customLock = customLock;
            ticketsAvailable = totalTicket;
        }

        public void run() {

            System.out.println("Waiting to book ticket : "
                    + Thread.currentThread().getName());
            /* get hold of lock for booking ticket */
            customLock.lock();
            if (ticketsAvailable > 0) {
                System.out.println("Ticket booking started  for : "
                        + Thread.currentThread().getName());

                // Ticket booking time is 2 sec, so sleep for 2sec
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Interrupted");
                }
                /* Update available ticket count */
                ticketsAvailable--;
                System.out.println("Congratulation!!, Ticket BOOKED "
                        + "successfully for : " + Thread.currentThread().getName());
                System.out.println("currently ticketsAvailable = "
                        + ticketsAvailable);
            } else {
                ticketsAvailable--;
                System.out.println("Sorry!! Ticket NOT BOOKED for : "
                        + Thread.currentThread().getName()
                        + ". Current booking status is Waiting list(W/L): "
                        + Math.abs(ticketsAvailable));
            }
            customLock.unlock();
        }
    }

    private interface CustomLock {
        void lock();

        boolean tryLock();

        void unlock();
    }

    private static class CustomReentrantLock implements CustomLock {
        /* Maintain number of locks acquired by a thread */
        int lockHoldCount;

        /* ID of thread which is currently holding the lock. */
        long threadId;

        /**
         * Creates an instance of CustomReentrantLock and Initial lock hold count is
         * 0.
         */
        CustomReentrantLock() {
            lockHoldCount = 0;
        }

        @Override
        public synchronized void lock() {
            /*
             * Acquires the lock if it is not held by another thread and set lock
             * hold count to 1.
             */
            if (lockHoldCount == 0) {
                lockHoldCount++;
                threadId = Thread.currentThread().getId();
            }
            /*
             * If current thread already holds lock then hold count is increased by
             * 1 - Chain locking.
             */
            else if (lockHoldCount > 0
                    && threadId == Thread.currentThread().getId()) {
                lockHoldCount++;
            }
            // If the lock is held by another thread then the current
            // thread waits for another thread to release lock.
            else {
                try {
                    wait();
                    lockHoldCount++;
                    threadId = Thread.currentThread().getId();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        }

        @Override
        public synchronized void unlock() {
            /*
             * If current thread is not holding the lock, if unlock is called it
             * throws IllegalMonitorStateException.
             */
            if (lockHoldCount == 0)
                throw new IllegalMonitorStateException();
            /* If lock is held, decrement lock hold count by 1 */
            lockHoldCount--;

            /*
             * If lockHoldCount is 0, lock is released and waiting thread is
             * notified.
             */
            if (lockHoldCount == 0)
                notify();

        }

        @Override
        public synchronized boolean tryLock() {
            /*
             * Acquires the lock if it is not held by another thread and // returns
             * true
             */
            if (lockHoldCount == 0) {
                lock();
                return true;
            }
            // If lock is held by another thread then method return false.
            else
                return false;
        }
    }
}
