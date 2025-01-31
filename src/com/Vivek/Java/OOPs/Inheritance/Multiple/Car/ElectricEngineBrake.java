package com.Vivek.Java.OOPs.Inheritance.Multiple.Car;

public class ElectricEngineBrake implements Brake{
    @Override
    public void stop() {
        System.out.println("Electric engine brake applying");
    }
}
