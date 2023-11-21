package com.Vivek.OOPs.SingletonClass;

public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();
        System.out.println(
                 "Object one: " + obj + "\n" +
                 "Object two: " + obj2+ "\n" +
                 "Object three: " + obj3 + "\n"
        );
    }
}
