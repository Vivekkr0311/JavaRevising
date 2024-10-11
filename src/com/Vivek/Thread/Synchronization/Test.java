package com.Vivek.Thread.Synchronization;

public class Test {
    public static void main(String[] args) {
        // counter object will act as common source for two threads.
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try{
            // Making sure both threads are finished.
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }

        // Even if both the threads are finished, counter is not 2000, you will some value lesser than 2000,
        // sometimes you might get exact 2000.
        // This is happening because two thread are working on a common source that is counter.
        // They might read and increment the counter at the same time, which is leading their action to be skipped,
        // which causing counter to be less than 2000.
        // In the case, where their actions are not happening at the same time, you will get complete 2000.

        // To solve this issue we need to synchronize the threads, so that they will not access the common resource
        // at the same time, for implementing this we use 'synchronize' keyword.
        System.out.println(counter.getCounter());
    }
}
