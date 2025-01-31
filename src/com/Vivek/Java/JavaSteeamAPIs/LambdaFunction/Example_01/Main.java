package com.Vivek.Java.JavaSteeamAPIs.LambdaFunction.Example_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Vivek", 89.0f);
        Student student2 = new Student(2, "Vivek One", 90.0f);
        Student student3 = new Student(3, "Vivek Two", 60.0f);
        Student student4 = new Student(4, "Vivek Three", 49.0f);
        Student student5 = new Student(5, "Vivek Four", 98.0f);
        Student student6 = new Student(6, "Vivek Five", 99.0f);
        Student student7 = new Student(7, "Vivek Six", 67.0f);
        Student student8 = new Student(8, "Vivek Seven", 90.0f);

        List<Student> list = new ArrayList<>();
        list.addAll(Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8));

        list.sort((obj1, obj2) -> -(int) (obj1.getMarks() - obj2.getMarks())); // -ve sign for descending order.
        System.out.println(list);
    }
}
