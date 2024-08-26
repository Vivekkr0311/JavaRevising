package com.Vivek.Thread.Basic.ThreadClass;

public class Basic {
    public static void main(String[] args) {
        World w = new World();
        w.start();

        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
