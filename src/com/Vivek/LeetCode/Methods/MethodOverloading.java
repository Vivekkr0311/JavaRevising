package com.Vivek.LeetCode.Methods;

public class MethodOverloading {
    public static void main(String[] args) {

    }

    static void methodOne(int a){
        System.out.println("[+] Call from methodOne: " + a);
    }

    static void methodOne(float a){
        System.out.println("[+] Call from another methodOne with different parameter: " + a);
    }
}
