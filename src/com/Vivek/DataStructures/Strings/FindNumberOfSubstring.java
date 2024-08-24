package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class FindNumberOfSubstring {

    private static int numberOfTimeSubstringPresent(String input, String subtring){
        int count = 0;
        for(int i = 0; i <= input.length() - subtring.length(); i++){
            if(input.substring(i, i + subtring.length()).equals(subtring)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String input = scanner.nextLine();
        System.out.println("Enter your substring: ");
        String substring = scanner.nextLine();

        System.out.println("Number of times " + substring + " is present, is " + numberOfTimeSubstringPresent(input, substring));
    }
}
