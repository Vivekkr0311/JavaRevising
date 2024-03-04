package com.Vivek.JavaMultiThreading.SimpleExample;

public class Main {
    public static void main(String[] args) {
        MultiThread thead1 = new MultiThread();
        MultiThread thead2 = new MultiThread();

//        thead1.run(); this will not run the thread as a separate thread, it will execute
//         in a single threaded environment.

//        thead1.start(); will create a new thread branch and will execute it.
        thead1.start();
        thead2.start();
    }
}

