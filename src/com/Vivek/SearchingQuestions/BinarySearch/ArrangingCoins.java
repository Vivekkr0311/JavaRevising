package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class ArrangingCoins {
    private static int arrangeCoins(int n){
        int levelStart = 1;
        int levelEnd = n;

        while(levelStart <= levelEnd){
            int currLevel = levelStart + ((levelEnd - levelStart) >> 1);
            long coinsRequired = ((long)currLevel * (currLevel + 1)) >> 1;

            if(coinsRequired == n){
                return currLevel;
            }else if(coinsRequired > n){
                levelEnd = currLevel - 1;
            }else{
                levelStart = currLevel + 1;
            }
        }

        return levelEnd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of coins: ");

        int n = scanner.nextInt();
        System.out.println("Number of rows filled: " + arrangeCoins(n));
    }
}
