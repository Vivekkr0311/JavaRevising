package com.Vivek.OOPs.Annotations;


//Annotations are internally interfaces
public class Main {

    @customeAnnotation
    static void method(){
        System.out.println("Yayyy!");
    }
    public static void main(String[] args) {
        method();
    }
}
