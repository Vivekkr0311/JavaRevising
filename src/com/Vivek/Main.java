package com.Vivek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "Vivek";
        String nameTwo = "Vivek";
        // Both are refering to the same String object.
        System.out.println(name == nameTwo);
        
        //Now a new String is object is created therefore now
        //both variable will be refering to two different String variables.
        nameTwo = new String("Vivek");
        System.out.println(name == nameTwo);


        // This will not change the actual String object, instead it will create a new String object.
        name = name.substring(0, 4) + 'z';
        System.out.println(name);
    }
}
