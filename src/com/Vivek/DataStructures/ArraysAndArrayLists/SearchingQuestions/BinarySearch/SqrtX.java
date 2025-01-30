package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class SqrtX {

    private static int sqrtX(int x){
        if(x == 0 || x == 1){
            return x;
        }

        int start = 1;
        int end = x >> 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            long midSquared = (long) mid * mid;

            if(midSquared == x){
                return mid;
            }else if(midSquared > x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x = scanner.nextInt();
        System.out.println("Square root of: " + x + " is " + sqrtX(x));
    }
}
