package com.Vivek.OOPs.Inheritance.Multiple.Car;

public class PowerEngineBrake implements Brake{
    @Override
    public void stop() {
        System.out.println("Power engine brakes");
    }
}
