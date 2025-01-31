package com.Vivek.LeetCode.Methods;

public class ScopingAndShadowing {
    int a = 10;
    public static void main(String[] args) {
         int a = 20;
    }

    static void scopingExample(){
        int a = 10;
        {
            // int a = 20; This will not work. Because you can't initialize a variable again which is already initialized globally.
            a = 15; // But you can re-assign a new value;
            int b = 18;
            System.out.println("[+] Value is chages: " + a);
        }

        //System.out.println(b); This will not work, as "b" is inside inner block.
        //You can only access stuffs which are in outer block.
        //Inner block can access outer block stuff, but outer block cannot access inner block stuff.
    }
}
