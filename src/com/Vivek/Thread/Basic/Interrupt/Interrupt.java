package com.Vivek.Thread.Basic.Interrupt;

public class Interrupt extends Thread{

    @Override
    public void run(){
        try{
            Thread.sleep(1000);
            System.out.println("Thread is running!");
        }catch (Exception e){
            System.out.println("Interrupt: " + e);
        }
    }

    public static void main(String[] args) {
        Interrupt thread = new Interrupt();
        thread.start();

        // interrupt() stops the thread in the state where ever it was.
        thread.interrupt();
    }
}
