package com.Vivek.LeetCode.Greedy;

import java.util.Scanner;

public class ValidPalindromeTwo {

    static boolean isPlingdrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

    // Efficient
    static boolean isValid(String s, int start, int end, int deletion){
        if(deletion < 0){
            return false;
        }

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return isValid(s, start + 1, end, deletion - 1) || isValid(s, start, end - 1, deletion - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    static boolean isValidTwo(String s, int start, int end, int deletion){
        if(deletion < 0){
            return false;
        }

        if(s.charAt(start) == s.charAt(end)){
            return isValidTwo(s, start + 1, end - 1, deletion);
        }
        return isValidTwo(s, start + 1, end, deletion - 1) || isValidTwo(s,start, end - 1, deletion - 1);
    }

    public static void main(String[] args) {
        // Input:
        // aba : true
        // abca : true
        // deeee : true
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");
        String n = input.nextLine();

        System.out.println(isValid(n, 0, n.length() - 1, 0));
    }
}
