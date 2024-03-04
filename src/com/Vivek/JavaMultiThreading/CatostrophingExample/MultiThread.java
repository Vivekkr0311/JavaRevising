package com.Vivek.JavaMultiThreading.CatostrophingExample;

public class MultiThread extends Thread{

    // This example shows if any of the thread has some problem,
    // it does not affect other threads.
    private int theadNumber;

    public MultiThread(int theadNumber){
        this.theadNumber = theadNumber;
    }

    @Override
    public void run() throws RuntimeException{
        for(int i = 0; i <=5; i++){
            System.out.println(i + " from thread " + this.theadNumber);
            if(this.theadNumber == 3){
                throw new RuntimeException();
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
