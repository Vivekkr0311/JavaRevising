package com.Vivek.LeetCode.Maths.BitManipulationTricks;

import java.util.Scanner;

public class PowerOfTwo {

    static boolean isPowerOfTwo(int num){
        if(num == 0){
            return false;
        }
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number to check if it is power of 2: ");
        int num = input.nextInt();

        System.out.println(num + " is power of 2 ?: " + isPowerOfTwo(num));
    }
}
