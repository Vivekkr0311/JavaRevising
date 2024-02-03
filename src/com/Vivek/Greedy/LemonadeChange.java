package com.Vivek.Greedy;
import java.util.Arrays;
import java.util.Scanner;

public class LemonadeChange {

    static boolean lemonadeChange(int[] bills){
        final int eachBuy = 5;

        int collectedChange = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == eachBuy){
                collectedChange += bills[i];
                continue;
            }
            if(collectedChange < bills[i] - eachBuy){
                return false;
            }
            int remainder = bills[i] - eachBuy;
            collectedChange -= remainder;
            collectedChange += eachBuy;
        }
        return true;
    }

    public static void main(String[] args) {

        // Test case:
        // [5,5,5,5,20,20,5,5,20,5]
        Scanner input = new Scanner(System.in);
        System.out.println("How many customers? ");
        int n = input.nextInt();
        int[] bills = new int[n];
        System.out.println("Enter bill for each customer: ");
        for(int i = 0; i < n; i++){
            bills[i] = input.nextInt();
        }

        System.out.println(lemonadeChange(bills));
    }
}
