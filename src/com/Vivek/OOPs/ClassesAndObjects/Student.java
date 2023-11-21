package com.Vivek.OOPs.ClassesAndObjects;

public class Student {
    private String name;
    private int rollNo;

    //Default constructor
    Student(){
        this.name = "No Name given";
        this.rollNo = -1;
    }

    //Parameterized constructor
    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    //Copy constructor
    Student(Student other){
        this.name = other.name;
        this.rollNo = other.rollNo;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }

    public String getName(){
        return this.name;
    }

    public int getRollNo(){
        return this.rollNo;
    }

    //toString method overridden from Object class.
    @Override
    public String toString(){
        return this.name + " " + this.rollNo;
    }


    //read documentation, finalize is deprecated now.
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Object destroyed.");
    }
}
