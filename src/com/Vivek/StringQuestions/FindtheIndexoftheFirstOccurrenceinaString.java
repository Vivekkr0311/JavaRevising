package com.Vivek.StringQuestions;

import java.util.Scanner;

public class FindtheIndexoftheFirstOccurrenceinaString {

    private static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return -1;
        }

        int n = haystack.length();
        int l = needle.length();

        for(int i = 0; i <= n - l; i++){
            if(haystack.substring(i, i + l).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the haystack: ");
        String haystack = scanner.nextLine();
        System.out.println("Enter the needle: ");
        String needle = scanner.nextLine();

        System.out.println("Ans: " + strStr(haystack, needle));
    }
}
