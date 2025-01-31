package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.PalingdromNumber;
import com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.ReverseNumber.ReverseNumberWithHelper;

import java.util.Scanner;

public class PalingdromeNumberCheck {

    static boolean isPalingdrome(long number){
        return number == ReverseNumberWithHelper.reverseNumber(number);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();

        System.out.println("Is number was palingdrome: " + isPalingdrome(number));
    }
}
