package com.Vivek.Recursion.SimpleProblemsUsingRecursion.NumberOfStepsToReduceToZero;

import java.util.Scanner;

public class NumberOfSteps {

    static long numberOfSteps(long n, long step){
        if(n == 0){
            return step;
        }

        if((n&1) == 0){
            return numberOfSteps(n/2, step + 1);
        }
        return numberOfSteps(n -1, step + 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        System.out.println("Number of step to reduce: " + number + " to zero is " + numberOfSteps(number, 0));
    }
}
