package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class StringPermutations {

    static void stringPermutations(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        for(int i = 0; i <= processed.length(); i++){
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            stringPermutations(first + ch + second, unprocessed.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputString = input.nextLine();

        System.out.println("Permutations of " +  inputString + " are ");
        stringPermutations("", inputString);
    }
}
