package com.Vivek.OOPs.Inheritance.Multiple.Car;

public class CDPlayer implements Media{
    @Override
    public void start() {
        System.out.println("CD player starts");
    }

    @Override
    public void stop() {
        System.out.println("CD player stops");
    }

    @Override
    public void pause() {
        System.out.println("CD player pause");
    }
}
