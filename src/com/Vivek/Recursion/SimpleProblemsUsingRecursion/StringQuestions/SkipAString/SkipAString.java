package com.Vivek.Recursion.SimpleProblemsUsingRecursion.StringQuestions.SkipAString;

import java.util.Scanner;

public class SkipAString {

    static String skipAString(String unprocessed){
        if(unprocessed.isEmpty()){
            return "";
        }

        if(unprocessed.startsWith("apple")){
            return skipAString(unprocessed.substring(5));
        }else{
            return unprocessed.charAt(0) + skipAString(unprocessed.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();

        System.out.println(skipAString(inputString));
    }
}
