package com.Vivek.ConditionsAndLoop;

import java.util.Scanner;
public class LargestOfThreeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("[?] Input three number to check: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.println("[+] Greatest number of three is (General way): " + greatestNumber(a, b, c));
        System.out.println("[+] Greatest number of three is (Optimized way): " + greatestNumberTwo(a, b, c));
    }

    static int greatestNumber(int a, int b, int c){
        //This is general way of finding greatest of three number.
        int answer = a;
        if(b > answer){
            answer = b;
        }
        if(c >  answer){
            answer = c;
        }
        return answer;
    }

    static int greatestNumberTwo(int a, int b, int c){
        //This is optimized way of finding greatest of three.
        return Math.max(a, Math.max(b, c));
    }
}
