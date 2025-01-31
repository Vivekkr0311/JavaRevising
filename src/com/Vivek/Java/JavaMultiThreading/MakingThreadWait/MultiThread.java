package com.Vivek.Java.JavaMultiThreading.MakingThreadWait;

public class MultiThread implements Runnable{
    private int threadNumber;

    MultiThread(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for(int i = 0; i <= 10; i++){
            System.out.println(i + " from thread number " + this.threadNumber);
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
