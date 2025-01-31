package com.Vivek.Java.JavaMultiThreading.ThreadLifeCycle;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("t1 thread running");
        try{
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());

        // RUNNABLE state means either the thread is running or it is ready to run
        t1.start();
        System.out.println(t1.getState());

        // com.Vivek.Java.Generics.Main class thread state, we get RUNNABLE, means RUNNABLE also represents running thread
        System.out.println(Thread.currentThread().getState());

        // Making main thead sleep so that t1 can run
        Thread.sleep(200);

        // t1 because of its sleep went into TIMED_WAITING state
        System.out.println(t1.getState());

        // This will make main thread wait for t1 to complete, then main thread will start executing
        t1.join();

        // com.Vivek.Java.Generics.Main thread was waiting for t1 to complete its task,
        // and when t1 completed its work it got terminated
        // therefore you will get TERMINATED state for this thread t1
        System.out.println(t1.getState());
    }
}
