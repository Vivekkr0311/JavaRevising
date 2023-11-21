package com.Vivek.OOPs.Inheritance.Multiple;
class Main implements One, Two{

    @Override
    public void methodClassOne(){
        System.out.println("Method class one");
    }

    @Override
    public void methodClassTwo(){
        System.out.println("Method class two");
    }
    public static void main(String[] args) {
        Main obj = new Main();
        obj.methodClassOne();
        obj.methodClassTwo();
    }
}
