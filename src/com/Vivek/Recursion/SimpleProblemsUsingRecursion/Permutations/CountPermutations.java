package com.Vivek.Recursion.SimpleProblemsUsingRecursion.Permutations;

import java.util.Scanner;

public class CountPermutations {

    //This can be solved using formula (3!), but we are solving in this way just to learn how to
    //pass values over recursion call.

    static int countPermutations(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }

        int count = 0;
        char ch = unprocessed.charAt(0);

        for(int i = 0; i <= processed.length(); i++){
            String first = processed.substring(0, i);
            String second = processed.substring(i);

            count = count +  countPermutations(first + ch + second, unprocessed.substring(1));
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputString = input.nextLine();
        System.out.println("Number of permutations are: " + countPermutations("", inputString));
    }
}
