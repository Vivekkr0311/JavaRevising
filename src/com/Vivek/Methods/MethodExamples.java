package com.Vivek.Methods;

import java.util.Scanner;

public class MethodExamples {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("[?] Insert a string: ");
        String anyString = in.nextLine();
        changeString(anyString);
        System.out.println("[-] Value is not change: " + anyString);
        //Initially, anyString --> object1 and name --> object1
        //After executing name = "Change Value!!"
        //Now, anyString --> object1 but name --> Change Value!! (technically speaking a "another new object").
    }

    static void changeString(String name){
        //It will not change the passed value, instead it will point to new object "Change value!!".
        //There is no concept of "pass by reference" in Java, there is only "pass by value"
        name = "Change value!!";
    }
}
