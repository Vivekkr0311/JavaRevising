package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.SubSetProblem;

import java.util.Scanner;

public class SubSetStringAscii {

    static void subsetStringAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch =  up.charAt(0);

        subsetStringAscii(p, up.substring(1));
        subsetStringAscii(p + ch, up.substring(1));
        subsetStringAscii(p + (ch +0), up.substring(1));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter input string: ");
        String str = input.nextLine();

        subsetStringAscii("", str);
    }
}
