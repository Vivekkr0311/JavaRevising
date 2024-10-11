package com.Vivek.Thread.Synchronization;

public class Counter {
    private int counter = 0;

    public void incrementCounter(){
        this.counter++;
    }

    public int getCounter(){
        return this.counter;
    }
}
