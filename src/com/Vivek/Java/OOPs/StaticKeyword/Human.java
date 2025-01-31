package com.Vivek.Java.OOPs.StaticKeyword;

public class Human {

    static{
        System.out.println("This is static block, this will execute only when first object of this class is created.");
    }

    private String name;
    private int age;
    private static long population = 0;

    Human(){
        this.name = "No name given to this human";
        this.age = -1;
        population += 1;
    }

    Human(String name, int age){
        this.name = name;
        this.age = age;
        population += 1;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public static long getPopulation(){
        return Human.population;
    }
    @Override
    public String toString(){
        return this.name + " " + this.age;
    }

    @Override
    protected void finalize() throws Throwable{
        population -= 1;
        System.out.println("Population decreased by 1 " + Human.getPopulation());
    }
}
