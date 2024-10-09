package com.Vivek.Thread.Basic.ThreadPriority;

public class ThreadPriority extends Thread{

    public ThreadPriority(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            String s = "a";
            for(int j = 0; j < 1000; j++){
                s += "a";
            }

            System.out.println("Thread name: " + Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority() + ", Count: " + i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriority l = new ThreadPriority("Low or Min Priority");
        ThreadPriority m = new ThreadPriority("Medium or Normal Priority");
        ThreadPriority h = new ThreadPriority("High or Max Priority");

        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();
    }
}
