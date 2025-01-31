package com.Vivek.Java.JavaMultiThreading.Thread.Synchronization;

public class MyThread_Synchronized extends Thread {
    private Counter_With_Synchronization counter;

    public MyThread_Synchronized(Counter_With_Synchronization counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){
            counter.incrementCounter();
        }
    }
}
