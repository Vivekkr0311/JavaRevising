package com.Vivek.Java.JavaMultiThreading.Thread.Basic.ThreadClass;

public class World extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
