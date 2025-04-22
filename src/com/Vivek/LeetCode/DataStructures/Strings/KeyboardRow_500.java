package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KeyboardRow_500 {
    private static String[] findWords(String[] words) {
        int wordCount = words.length;
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < wordCount; i++) {
            String currWord = words[i].toLowerCase();
            String rowToUse = "";
            char firstChar = currWord.charAt(0);
            if (row1.indexOf(firstChar) != -1) {
                rowToUse = row1;
            } else if (row2.indexOf(firstChar) != -1) {
                rowToUse = row2;
            } else if (row3.indexOf(firstChar) != -1) {
                rowToUse = row3;
            }


            boolean canBeTyped = true;
            for (int j = 1; j < currWord.length(); j++) {
                if (rowToUse.indexOf(currWord.charAt(j)) == -1) {
                    canBeTyped = false;
                    break;
                }
            }

            if(canBeTyped){
                result.add(words[i]);
            }
        }

        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of words:");
        int n = scanner.nextInt();

        String[] words = new String[n];
        System.out.println("Enter the words:");
        scanner.nextLine(); // Consume the newline character
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        System.out.println("Words that can be typed using one row of the keyboard:" + Arrays.toString(findWords(words)));
    }
}