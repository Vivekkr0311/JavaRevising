package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class FindingSmallestLetterGreaterThanTheTarget {
    private static char nextGreatestLetter(char[] letters, char target) {
        int startIdx = 0;
        int lastIdx = letters.length - 1;

        while(startIdx <= lastIdx){
            int mid = startIdx + ((lastIdx - startIdx) >> 1);

            if(letters[mid] <= target){
                startIdx = mid + 1;
            }else{
                lastIdx = mid - 1;
            }
        }

        return letters[startIdx % letters.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many character in the array ?: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        char[] letters = new char[n];
        System.out.println("Enter each letter: ");
        for(int i = 0; i < n; i++){
            letters[i] = scanner.nextLine().charAt(0);
        }

        System.out.println("Enter the target: ");
        char target = scanner.nextLine().charAt(0);

        System.out.println("Smallest character greater than the target: " + nextGreatestLetter(letters, target));
    }
}
