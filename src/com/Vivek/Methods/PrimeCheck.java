package com.Vivek.Methods;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("[?] Enter a number: ");
        int number = in.nextInt();
        System.out.println("[!] Is number " + number + " is a prime ?: " + ((isPrime(number)) ? "Yes" : "No"));
    }

    static boolean isPrime(int number){
        if(number <= 1){
            return false;
        }

        int i = 2;
        while( i*i <= number){
            if(number%i == 0){
                return false;
            }else{
                i++;
            }
        }

        return i*i > number;
    }
}
