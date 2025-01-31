package com.Vivek.LeetCode.BitManipulationTricks;

import java.util.Scanner;

public class CheckIfKthBitIsSet {

    static boolean isSetBit(int num, int k){
        if(num == 0){
            return false;
        }

        return (num & (1 << k)) == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number whose kth bit (LSB) you wanna check: ");
        int num = input.nextInt();
        System.out.println("Enter which LSB (kth) bit: ");
        int k = input.nextInt();
        System.out.println("Your num " + num + " in binary representation is " + Integer.toBinaryString(num));
        System.out.println(k + "th bit of " + num + " is set: " + isSetBit(num, k));
    }
}
