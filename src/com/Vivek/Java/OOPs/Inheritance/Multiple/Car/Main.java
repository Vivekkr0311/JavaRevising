package com.Vivek.Java.OOPs.Inheritance.Multiple.Car;

public class Main {
    public static void main(String[] args) {
        NiceCar myCar = new NiceCar();
        myCar.startCar();
        myCar.accCar();
        myCar.startMedia();
        myCar.pauseMedia();
        myCar.stopMedia();
        myCar.appplyBrake();
        myCar.stopEngine();

        myCar.changeEngine(new ElectricEngine());
        myCar.changeBrake(new ElectricEngineBrake());
        myCar.changeMedia(new SmartPlayer());

        System.out.println("Car specs changed");

        myCar.startCar();
        myCar.accCar();
        myCar.startMedia();
        myCar.pauseMedia();
        myCar.stopMedia();
        myCar.appplyBrake();
        myCar.stopEngine();
    }
}
