package com.Vivek.Java.JavaMultiThreading.Thread.Basic.RunnableInterface;

public class ThreadTwo implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
