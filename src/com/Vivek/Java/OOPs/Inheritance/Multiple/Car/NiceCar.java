package com.Vivek.Java.OOPs.Inheritance.Multiple.Car;

public class NiceCar {
    private Engine engine = new PowerEngine();
    private Brake brake = new PowerEngineBrake();
    private Media player = new CDPlayer();

    public void changeEngine(Engine newEngine){
        this.engine = newEngine;
    }

    public void changeBrake(Brake newBrake){
        this.brake = newBrake;
    }

    public void changeMedia(Media newMedia){
        this.player = newMedia;
    }

    void startCar(){
        engine.start();
    }

    void stopEngine(){
        engine.stop();
    }

    void accCar(){
        engine.acc();
    }

    void appplyBrake(){
        brake.stop();
    }

    void startMedia(){
        player.start();
    }

    void stopMedia(){
        player.stop();
    }

    void pauseMedia(){
        player.pause();
    }
}
