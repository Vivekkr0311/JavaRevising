package com.Vivek.Thread.Basic.RunnableInterface;

public class ThreadTwo implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
