package com.Vivek.Recursion.SimpleProblemsUsingRecursion.StringQuestions.SkipNotAApple;

import java.util.Scanner;

public class SkipNotApple {
    static String skipNotAApple(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("app") && !str.startsWith("apple")){
            return skipNotAApple(str.substring(3));
        }else{
            return str.charAt(0) + skipNotAApple(str.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert your string: ");
        String str = input.nextLine();

        System.out.println("Output: " + skipNotAApple(str));
    }
}
