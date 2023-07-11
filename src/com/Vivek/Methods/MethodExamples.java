package com.Vivek.Methods;

import java.util.Arrays;
import java.util.Scanner;


//primitives data type such as int, float, double, char can be passed by value.
//non-primitives such as Object, String can be passed by value of the reference.

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

        int []arr = {1, 2, 3, 4, 5};
        changeArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void changeString(String name){
        //It will not change the passed value, instead it will point to new object "Change value!!".
        //There is no concept of "pass by reference" in Java, there is only "pass by value"
        //Here new object is created, therefore even though string is a non-primitive we could not change the original string.
        name = "Change value!!";
    }

    static void changeArray(int []arr){
        //This will change the original arr. As arr is non-primitive and here value of reference is passed.
        for(int i = 0; i <  arr.length; i++){
            System.out.println("[+] Changing value from " + arr[i] + " to " + arr[i]*2);
            arr[i] = arr[i]*2;
        }
    }
}
