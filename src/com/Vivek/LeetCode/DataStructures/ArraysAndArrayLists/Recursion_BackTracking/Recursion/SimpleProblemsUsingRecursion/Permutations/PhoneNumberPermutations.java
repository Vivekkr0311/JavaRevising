package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.Permutations;

import java.util.Scanner;

public class PhoneNumberPermutations {

    private static final String[] phonePadMapping = {
            "", //0
            "", //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tux", //8
            "wxyz" //9
    };

    static void phonePad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char)('a' + i);
            phonePad(p + ch, up.substring(1));
        }
    }

    static void phonePadTwo(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String letters = phonePadMapping[digit];

        for(int i = 0; i < letters.length(); i++){
            char letter = letters.charAt(i);
            phonePad(p + letter, up.substring(1));
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter key combination: ");
        String keyCombination = input.nextLine();

        phonePadTwo("", keyCombination);
    }
}
