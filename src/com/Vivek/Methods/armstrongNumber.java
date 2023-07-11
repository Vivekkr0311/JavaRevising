package com.Vivek.Methods;

import java.util.Scanner;

public class armstrongNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("[?] Enter a number: ");
        int number = in.nextInt();
        System.out.println((isArmstrongNumber(number)) ? "[+] Number is armstrong number" : "[-] Number is not armstrong number.");
    }

    static boolean isArmstrongNumber(int number){
        int initalNumber = number;
        int finalNumber = 0;
        while(number > 0){
            int rem = number%10;
            finalNumber = finalNumber + rem*rem*rem;
            number /= 10;
        }

        return initalNumber == finalNumber;
    }
}
