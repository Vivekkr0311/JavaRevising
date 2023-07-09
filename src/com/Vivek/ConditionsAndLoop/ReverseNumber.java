package com.Vivek.ConditionsAndLoop;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("[?] Enter number to be reversed: ");
        int number = in.nextInt();

        System.out.println("[+] Reversed number is: " +  reversedNumber(number));
    }

    static int reversedNumber(int number){

        int answer = 0;
        while(number > 0){
            answer = answer*10 + number%10;

            number /= 10;
        }

        return answer;
    }
}
