package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class SubsequenceOfOtherString {

    private static boolean subsequenceOtherString(String mainString, String subsequence){
        int mainStringLength = mainString.length();
        int subsequenceLength = subsequence.length();

        if(mainStringLength == 0 || subsequenceLength == 0 || mainStringLength < subsequenceLength){
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

    private static boolean subsequenceOfOtherStringRecursive(String mainString, String subsequence, int idxOfMain, int idxOfSubsequence){
        if(idxOfMain == mainString.length() && idxOfSubsequence != subsequence.length()){
            return false;
        }

        if(idxOfSubsequence == subsequence.length()){
            return true;
        }

        if(mainString.charAt(idxOfMain) == subsequence.charAt(idxOfSubsequence)){
            return subsequenceOfOtherStringRecursive(mainString, subsequence, idxOfMain + 1, idxOfSubsequence + 1);
        }else{
            return subsequenceOfOtherStringRecursive(mainString, subsequence, idxOfMain + 1, idxOfSubsequence);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.println("Enter the subsequence: ");
        String subsequence = scanner.nextLine();

        System.out.println(subsequence + " is subsequence of " + mainString + ": " + subsequenceOtherString(mainString, subsequence));
        System.out.println(subsequence + " is subsequence of " + mainString + ": " + subsequenceOfOtherStringRecursive(mainString, subsequence, 0, 0));
    }
}
