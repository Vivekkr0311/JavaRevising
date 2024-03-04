package com.Vivek.JavaMultiThreading.SimpleExample;

public class MultiThread extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
