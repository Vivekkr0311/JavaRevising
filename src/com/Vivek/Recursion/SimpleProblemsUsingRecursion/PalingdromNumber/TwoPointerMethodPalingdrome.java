package com.Vivek.Recursion.SimpleProblemsUsingRecursion.PalingdromNumber;

import java.util.Scanner;

public class TwoPointerMethodPalingdrome {

    static boolean isPalingdrome(String n, int start, int end){
        if(start > end){
            return false;
        }

        if(n.charAt(start) == n.charAt(end)){
            isPalingdrome(n, ++start, --end);
        }else{
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();

        System.out.println("Is number a palingdrome: " + number + " " + isPalingdrome(number, 0, number.length()-1));
    }
}
