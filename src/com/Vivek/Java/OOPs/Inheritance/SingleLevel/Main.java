package com.Vivek.Java.OOPs.Inheritance.SingleLevel;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(2, 3, 4);
        BoxWeight box2 = new BoxWeight(4, 5, 6, 10);

        Box box3 = new BoxWeight(2, 4, 5, 5);
//        BoxWeight box4 = (BoxWeight) new Box(3, 4, 5);

        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);
//        System.out.println(box4);

        System.out.println(box2.weight);

        //Below line will show error, because reference variable is of type parent class,
        //and what you can access is determine by the type of the reference variable,
        //parent class cannot access the members of the child class, this reference variable
        //box cannot access weight which is a member of the child class.
//        System.out.println(box3.weight);
    }
}
