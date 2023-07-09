package com.Vivek.ConditionsAndLoop;

import java.util.Scanner;

public class CountingOccurrences {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        System.out.print("[?] Give number and digit you wanna find: ");
        int number = in.nextInt();
        int digit = in.nextInt();

        System.out.println("[+] Number of times " + digit + " occured in " + number + " is " + numberOfTimes(number, digit));
    }

    static int numberOfTimes(int number, int digit){
        int count = 0;

        while(number > 0){
            if(number%10 == digit){
                count++;
            }
            number /= 10;
        }

        return count;
    }
}
