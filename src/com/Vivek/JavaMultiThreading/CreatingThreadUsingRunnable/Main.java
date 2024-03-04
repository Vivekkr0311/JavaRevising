package com.Vivek.JavaMultiThreading.CreatingThreadUsingRunnable;

public class Main {
    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++){
            MultiThread threadObj = new MultiThread(i);
            Thread myThread = new Thread(threadObj);
            myThread.start();
        }
    }
}
