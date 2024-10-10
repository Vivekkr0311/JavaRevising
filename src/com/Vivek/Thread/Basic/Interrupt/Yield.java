package com.Vivek.Thread.Basic.Interrupt;

public class Yield extends Thread{

    @Override
    public void run(){
        try{
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + ", Count: " + i);

                // yield is hinting the scheduler that it is free to give chance to other thread for execution
                // it is choice of scheduler whether it will give other thread chance or not
                Thread.yield();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Yield t1 = new Yield();
        Yield t2 = new Yield();
        t1.start();
        t2.start();
    }
}
