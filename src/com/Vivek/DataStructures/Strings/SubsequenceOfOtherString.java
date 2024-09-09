package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class SubsequenceOfOtherString {

    private static boolean subsequenceOtherString(String mainString, String subsequence){
        int mainStringLength = mainString.length();
        int subsequenceLength = subsequence.length();
        
        if(mainStringLength == 0 || subsequenceLength == 0 || mainStringLength > subsequenceLength){
            return false;
        }

        int mainStringIdx = 0;
        int subsequenceIdx = 0;
        while(mainStringIdx < mainStringLength && subsequenceIdx < subsequenceLength){
            if(mainString.charAt(mainStringIdx) == subsequence.charAt(subsequenceIdx)){
                mainStringIdx++;
                subsequenceIdx++;
            }else{
                mainStringIdx++;
            }
        }
        return subsequenceIdx == subsequenceLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.println("Enter the subsequence: ");
        String subsequence = scanner.nextLine();

        System.out.println(subsequence + " is subsequence of " + mainString + ": " + subsequenceOtherString(mainString, subsequence));
    }
}
