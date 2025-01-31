package com.Vivek.Java.JavaMultiThreading.MakingThreadWait;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        // This will just break whole point of using Thread.
        // It will execute each thread one by one.
        for(int i = 0; i <= 5; i++){
            MultiThread myThreadObj = new MultiThread(i);
            Thread myThread = new Thread(myThreadObj);
            myThread.start();
            myThread.join();
        }
    }
}
