package com.Vivek.Java.OOPs.InnerClass;

class Test{
    String name;

    Test(String name){
        this.name = name;
    }
}
public class InnerClassExample2 {
    public static void main(String[] args) {
        Test a = new Test("A");
        Test b = new Test("B");
    }
}
