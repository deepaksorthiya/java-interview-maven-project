package com.example.multithreading;

public class WaitNotifyDemo {

    public static void main(String[] args) {
        SharedObject obj = new SharedObject();

        Thread thread1 = new Thread(() -> {
            obj.printMessage();
        });

        Thread thread2 = new Thread(() -> {
            obj.setMessage("A message from thread1");
        });
        thread1.start();
        thread2.start();

    }

    private static class SharedObject {
        private volatile String message;

        public synchronized void setMessage(String message) {
            System.out.println("setMessage() Lock is held by : " + Thread.currentThread().getName());
            this.message = message;
            notify();
        }

        public synchronized void printMessage() {
            System.out.println("printMessage() Lock is held by : " + Thread.currentThread().getName());
            System.out.println(message);
            while (message == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(message);

        }
    }
}
