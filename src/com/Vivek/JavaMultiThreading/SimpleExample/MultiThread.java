package com.Vivek.JavaMultiThreading.SimpleExample;

public class MultiThread extends Thread{
    private int threadNumber;

    public MultiThread(int theadNumber){
        this.threadNumber = theadNumber;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i + " from " + this.threadNumber);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
