package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class LengthOfLastWord {

    private static int lengthOfLastWord(String input){
        String[] words = input.split(" ");
        int res = 0;
        for(int i = words.length - 1; i >= 0; i--){
            if(!words[i].isEmpty()){
                res = words[i].length();
                break;
            }else if(words[i].isEmpty()){
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        String input = scanner.nextLine();

        System.out.println("Length of last word: " + lengthOfLastWord(input));
    }
}
