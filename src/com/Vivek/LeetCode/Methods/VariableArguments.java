package com.Vivek.LeetCode.Methods;

public class VariableArguments {
    public static void main(String[] args) {
        vargsPrinting(1, 2, 3, 4, 5);
        System.out.println("[!] <<<<< Another call >>>>>");
        vargsPrinting(1, 2, 3);
    }

    static void vargsPrinting(int ...numbers){
        for(int x :  numbers){
            System.out.println("[+] Printing values of vargs: " + x);
        }
    }
}
