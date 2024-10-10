package com.Vivek.Thread.Basic.Interrupt;

public class DaemonThread extends Thread{
    // Daemon Thread run in the background, like Java garbage collector runs in the background.

    // User Thread are those thread which runs other thread like here main thread is a user thread
    // which will run another thread, and main thread that is user thread will keep waiting for the
    // another thread to finish its works then main thread will be exited.
    // To avoid this wait we can mark that another thread as Daemon Thread by using setDaemon(true) method
    // so that user thread will be exited, and it will not wait for the another thread to finish its work.
    @Override
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        DaemonThread thread1 = new DaemonThread();
        thread1.setDaemon(true);
        thread1.start();
        System.out.println("User thread that is main thread here, is exited.");
    }
}
