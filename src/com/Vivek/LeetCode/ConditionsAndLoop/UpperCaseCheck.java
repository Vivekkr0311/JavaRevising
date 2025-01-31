package com.Vivek.LeetCode.ConditionsAndLoop;

import java.util.Scanner;

public class UpperCaseCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char letter = in.next().trim().charAt(0);

        if(letter >= 'a' && letter <= 'z'){
            System.out.println("[v]  Lower case");
        }else if(letter >= 'A' && letter <= 'Z'){
            System.out.println("[^] Upper case");
        }else{
            System.out.println("[-] Not an alphabet");
        }
    }
}
