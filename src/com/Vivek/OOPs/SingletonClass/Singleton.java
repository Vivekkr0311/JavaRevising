package com.Vivek.OOPs.SingletonClass;

public class Singleton {
    //Singleton class, it's object cannot be created more than once.
    //In order to do so, we prevent calling the constructor of this class
    //more than once.

    private Singleton(){
        //We made constructor private, not it cannot be called from anywhere.
    }

    private static Singleton instance;

    //Now we are making a method which will return instance of this Singleton class
    //if instance is already created then this will return the instance otherwise if
    //not already created this will call the constructor and create a instance then
    //it will return that instance.
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }
}
