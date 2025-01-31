package com.Vivek.Java.OOPs.ClassesAndObjects;

public class Main {
    public static void main(String[] args) {

        Student kiara = new Student();
        kiara.setName("Kiara");
        kiara.setRollNo(1);

        Student vivek = new Student("Vivek", 2);

        System.out.println(kiara);
        System.out.println(vivek);

        System.out.println("Roll number of Kiara is " + kiara.getRollNo());
        System.out.println("Roll number of Vivek is " + vivek.getRollNo());

        Student kiara2 = new Student(kiara);
        System.out.println("Kiara2 is copy of Kiara with the same attributes: " + kiara2);


        //trying to call garbage collector
        Student temp = new Student();
        for(int i = 0; i < 1000000000; i++){
            temp = new Student();
        }
    }
}
