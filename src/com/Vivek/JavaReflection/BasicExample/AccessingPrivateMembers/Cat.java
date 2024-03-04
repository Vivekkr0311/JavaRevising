package com.Vivek.JavaReflection.BasicExample.AccessingPrivateMembers;

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

    @Override
    public String toString(){
        return this.name + " " + this.age;
    }
}
