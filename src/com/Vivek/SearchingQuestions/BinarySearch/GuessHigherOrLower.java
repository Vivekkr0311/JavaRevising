package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class GuessHigherOrLower {
    private static int guessN;

    private static int guess(int num){
        if(num == guessN){
            return 0;
        }else if(num > guessN){
            return 1;
        }else{
            return -1;
        }
    }

    private static int guessNumber(int num){
        int start = 1;
        int end = num;

        while(start <= end){
            int mid = start + ((end - start) >> 1);
            int isItCorrect = guess(mid);
            if(isItCorrect == 0){
                return mid;
            }else if(isItCorrect == -1){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter higher range: ");
        int h = scanner.nextInt();
        System.out.println("Enter the pick number: ");
        guessN = scanner.nextInt();

        System.out.println("Number you picked is: " + guessNumber(h));
    }
}
