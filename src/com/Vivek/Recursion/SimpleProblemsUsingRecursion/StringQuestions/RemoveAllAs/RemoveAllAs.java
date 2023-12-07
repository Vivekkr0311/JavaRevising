package com.Vivek.Recursion.SimpleProblemsUsingRecursion.StringQuestions.RemoveAllAs;

import java.util.Scanner;

public class RemoveAllAs {

    static void skipASolutionOne(String process, String unprocessed){
        if(unprocessed.length() == 0){
            System.out.println(process);
            return;
        }

        char ch = unprocessed.charAt(0);
        if(ch == 'a'){
            skipASolutionOne(process, unprocessed.substring(1));
        }else{
            skipASolutionOne(process + ch, unprocessed.substring(1));
        }
    }

    static void skipAWhilePrinting(String str, int len){
        if(len < 0){
            return;
        }

        if(str.charAt(len) == 'a'){
            System.out.print("");
            return;
        }

        skipAWhilePrinting(str, len - 1);
        System.out.print(str.charAt(len));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string containing 'a': ");
        String inputString = input.nextLine();
//        skipAWhilePrinting(inputString, inputString.length() -1);
        skipASolutionOne("", inputString);
    }
}
