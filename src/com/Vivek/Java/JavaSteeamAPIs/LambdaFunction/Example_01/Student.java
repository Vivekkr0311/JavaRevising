package com.Vivek.Java.JavaSteeamAPIs.LambdaFunction.Example_01;

public class Student {

    private String name;
    private int rollno;
    private float marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }



    Student(int rollno, String name, float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    Student(){
        this.rollno = -1;
        this.name = "Defult name";
        this.marks = 0.0f;
    }

    @Override
    public String toString(){
        return this.rollno + " " + this.name + " " + this.marks;
    }
}
