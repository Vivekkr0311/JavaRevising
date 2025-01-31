package com.Vivek.Java.JavaMultiThreading.Thread.Locks.ExampleOfInBuiltLocks;

public class Main {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };

        // In this case of in built locks, which is used by the synchronized keyword.
        // In this case, t1 might take forever to complete its task, which will
        // lead t2 to wait forever.
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
