package com.Vivek.Java.OOPs.Inheritance.Multiple.Car;

public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electric engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stops");
    }

    @Override
    public void acc() {
        System.out.println("Electric engine accelerates");
    }
}
