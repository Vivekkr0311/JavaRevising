package com.Vivek.Thread.Basic.RunnableInterface;

public class MainThread{

    public static void main(String[] args) {
        ThreadTwo obj = new ThreadTwo();
        Thread t = new Thread(obj);
        t.start();

        System.out.println(Thread.currentThread().getName());
    }
}
