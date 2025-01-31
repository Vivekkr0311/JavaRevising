package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.Permutations;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturningArrayStringPermutations {

    static ArrayList<String> stringArrayPermutations(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i <= processed.length(); i++){
            String first = processed.substring(0, i);
            String second = processed.substring(i);
            ans.addAll(stringArrayPermutations(first + ch + second, unprocessed.substring(1)));
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputString = input.nextLine();

        System.out.println("Permutations of " +  inputString +" are ");
        System.out.println(stringArrayPermutations("", inputString));

    }
}
