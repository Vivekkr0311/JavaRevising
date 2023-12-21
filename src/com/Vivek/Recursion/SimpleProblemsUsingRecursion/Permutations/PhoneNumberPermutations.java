package com.Vivek.Recursion.SimpleProblemsUsingRecursion.Permutations;

import java.util.Scanner;

public class PhoneNumberPermutations {

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


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter key combination: ");
        String keyCombination = input.nextLine();

        phonePad("", keyCombination);
    }
}
