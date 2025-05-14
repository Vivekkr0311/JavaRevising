package com.Vivek.LeetCode.Maths.BitManipulationTricks;

import java.util.Scanner;

public class EvenAndOdd {

    static boolean isEven(int num){
        if(num == 0){
            return false;
        }
        return (num & 1) == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number to check if it is even: ");
        int num = input.nextInt();

        System.out.println(num + " is even: " + isEven(num));
    }
}
