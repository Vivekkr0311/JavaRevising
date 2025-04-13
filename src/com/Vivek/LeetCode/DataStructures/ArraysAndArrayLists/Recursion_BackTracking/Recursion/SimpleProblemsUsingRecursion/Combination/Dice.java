package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.Combination;

import java.util.Scanner;

public class Dice {

    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= 6 && i <= target; i++){
            dice(p + i, target -i);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your number which you want to make using dice: ");
        int num = input.nextInt();

        dice("", num);
    }
}
