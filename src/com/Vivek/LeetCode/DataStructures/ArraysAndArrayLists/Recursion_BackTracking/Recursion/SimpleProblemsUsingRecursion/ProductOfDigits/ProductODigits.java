package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.ProductOfDigits;

import java.util.Scanner;

public class ProductODigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        System.out.println("Product of digits of " + number + " is " + productOfDigtis(number));
    }

    static int productOfDigtis(int n){
        if(n%10 == n){
            return n;
        }

        return (n%10) * productOfDigtis(n/10);
    }
}
