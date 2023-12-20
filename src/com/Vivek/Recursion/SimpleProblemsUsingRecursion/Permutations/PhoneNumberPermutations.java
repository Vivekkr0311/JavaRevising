package com.Vivek.Recursion.SimpleProblemsUsingRecursion.Permutations;

import java.util.Scanner;

public class PhoneNumberPermutations {

    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <=  p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutations(first + ch + second, up.substring(1));
        }
    }

    static void printPhoneNumberPermutations(int n){
        String[] numberTable = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        permutations("", numberTable[n - 1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter phone number: \nChose from below table:\nabc: 2 \ndef: 3\nghi: 4\njkl: 5\nmno:6\npqrs:7\ntuv: 8\nwxyz: 9\n:");
        int number = input.nextInt();
        if(number < 2 && number > 9){
            System.out.println("Please enter number with [2, 9]");
        }

        printPhoneNumberPermutations(number);
    }
}
