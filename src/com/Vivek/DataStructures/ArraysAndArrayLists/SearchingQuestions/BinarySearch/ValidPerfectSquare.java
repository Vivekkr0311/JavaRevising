package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class ValidPerfectSquare {
    private static boolean isPerfectSquare(int num){
        if(num == 0 || num == 1){
            return true;
        }

        int start = 0;
        int end = num >> 1;

        while(start <= end){
            int mid = start + ((end - start) >> 1);
            long square = (long) mid * mid;
            if(square == num){
                return true;
            }else if(square < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num  = input.nextInt();

        System.out.println("Perfect square of " + num + " exists ?: " + isPerfectSquare(num));
    }
}
