package com.Vivek.Java.JavaMultiThreading.CatostrophingExample;

public class Main {
    public static void main(String[] args) {
        for(int i = 1; i <=5; i++){
            MultiThread thread = new MultiThread(i);
            thread.start();
        }
    }
}
