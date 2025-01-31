package com.Vivek.LeetCode.BitManipulationTricks;

import java.util.Scanner;

public class ToggleBit {

    static int toggleBit(int num, int k){
        return num ^ (1 << (k - 1));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number whose kth bit you wanna change: ");
        int num = input.nextInt();
        int len = Integer.toBinaryString(num).length();
        System.out.println("You " + num + " in binary: " + Integer.toBinaryString(num));
        System.out.println("Enter the kth bit you wanna change (LSB): ");
        int k = input.nextInt();

        System.out.println("After toggling " + k + "th bit");
        String binaryString = Integer.toBinaryString(toggleBit(num, k));
        System.out.println(String.format("%" + len + "s", binaryString).replace(' ', '0'));
    }
}
