package com.Vivek.Thread.Basic.ThreadName;

public class MainThread extends Thread{

    public MainThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Thread Name: " + Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority() + ", Count: " + i);
        }
    }

    public static void main(String[] args) {
        MainThread t1 = new MainThread("Vivek");
        t1.start();
    }
}
