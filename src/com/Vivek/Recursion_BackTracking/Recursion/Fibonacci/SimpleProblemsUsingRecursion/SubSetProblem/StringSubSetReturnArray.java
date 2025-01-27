package com.Vivek.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.SubSetProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSubSetReturnArray {

    static ArrayList<String> subsetStringArray(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("'" + p + "'");
            return ans;
        }

        ArrayList<String> left = subsetStringArray(p + up.charAt(0), up.substring(1));
        ArrayList<String> right = subsetStringArray(p, up.substring(1));

        left.addAll(right);
        return left;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert your string: ");
        String str = input.nextLine();

        System.out.println(subsetStringArray("", str));
    }
}
