package com.Vivek.Java.AccessingPrivateMembers;

public class Cat {

    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    private void privateMethod(){
        System.out.println("This is a private method!!");
    }

    private static void privateAndStatic(String arg){
        System.out.println("This private and static method, parameter passed is " + arg);
    }

    @Override
    public String toString(){
        return this.name + " " + this.age;
    }
}
