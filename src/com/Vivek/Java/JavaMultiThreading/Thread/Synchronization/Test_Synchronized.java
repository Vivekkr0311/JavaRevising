package com.Vivek.Java.JavaMultiThreading.Thread.Synchronization;

public class Test_Synchronized {
    public static void main(String[] args) {
        // counter object will act as common source for two threads.
        Counter_With_Synchronization counter = new Counter_With_Synchronization();
        MyThread_Synchronized t1 = new MyThread_Synchronized(counter);
        MyThread_Synchronized t2 = new MyThread_Synchronized(counter);

        t1.start();
        t2.start();

        try{
            // Making sure both threads are finished.
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }

        // To solve this issue we need to synchronize the threads, so that they will not access the common resource
        // at the same time, for implementing this we use 'synchronize' keyword.
        System.out.println(counter.getCounter());
    }
}
