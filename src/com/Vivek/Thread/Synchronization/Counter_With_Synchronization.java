package com.Vivek.Thread.Synchronization;

public class Counter_With_Synchronization {
    private int counter = 0;

    public synchronized void incrementCounter(){
        synchronized (this){
            // this is a synchronized block
            // some code
        }
        this.counter++;
    }

    public int getCounter(){
        return this.counter;
    }
}
