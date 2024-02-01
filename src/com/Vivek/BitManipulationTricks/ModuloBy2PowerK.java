package com.Vivek.BitManipulationTricks;

import java.util.Scanner;

public class ModuloBy2PowerK {

    static int powerBy2(int k){
        return 2 << (k - 1);
    }

    static int modulo2PowerK(int num, int k){
        return num & ((1 << k) - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int num = input.nextInt();
        System.out.println("Enter k (power of 2): ");
        int k = input.nextInt();

        System.out.println(num + " % " + powerBy2(k) + " (2^" + k + ")"  +  " is: " + modulo2PowerK(num, k));
    }
}
