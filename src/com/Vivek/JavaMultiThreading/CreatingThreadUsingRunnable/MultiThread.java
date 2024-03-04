package com.Vivek.JavaMultiThreading.CreatingThreadUsingRunnable;

public class MultiThread implements Runnable{

    private int threadNumber;

    public MultiThread(int thradNumber){
        this.threadNumber = thradNumber;
    }

    @Override
    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println(i + " from thread number " + this.threadNumber);

            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }
}
