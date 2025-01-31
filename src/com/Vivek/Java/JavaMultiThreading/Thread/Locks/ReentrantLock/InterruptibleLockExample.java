package com.Vivek.Java.JavaMultiThreading.Thread.Locks.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLockExample {
    private final Lock lock = new ReentrantLock();

    public void criticalSection() {
        try {
            // Attempt to acquire the lock interruptibly
            lock.lockInterruptibly();
            try {
                // Critical section code here
                System.out.println("Lock acquired, executing critical section.");
                // Simulate some work
                Thread.sleep(1000);
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while waiting for the lock.");
        }
    }

    public static void main(String[] args) {
        InterruptibleLockExample example = new InterruptibleLockExample();
        Thread thread = new Thread(example::criticalSection);

        thread.start();

        // Interrupt the thread after a short delay
        try {
            Thread.sleep(200); // Give the thread some time to start
            thread.interrupt(); // Interrupt the thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}