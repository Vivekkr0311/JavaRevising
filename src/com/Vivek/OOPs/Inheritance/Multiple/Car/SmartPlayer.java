package com.Vivek.OOPs.Inheritance.Multiple.Car;

public class SmartPlayer implements Media{
    @Override
    public void start() {
        System.out.println("Smart Player starting");
    }

    @Override
    public void stop() {
        System.out.println("Smart player stopping");
    }

    @Override
    public void pause() {
        System.out.println("Smart player pausing");
    }
}
