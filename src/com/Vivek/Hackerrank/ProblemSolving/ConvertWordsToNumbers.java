package com.Vivek.Hackerrank.ProblemSolving;

import java.util.HashMap;
import java.util.Scanner;

public class ConvertWordsToNumbers {
    private static final HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
    }

    private static int convertWordsToNumbers(String input) {
        String[] words = input.toLowerCase().split(" ");
        int result = 0;
        int current = 0;

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                int val = map.get(words[i]);

                if (val == 100) {
                    current *= 100;
                } else if (val == 1000) {
                    result += current * 1000;
                    current = 0;
                } else {
                    current += val;
                }
            }
        }
        return result + current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number in words (e.g., 'one hundred twenty three'):");
        String input = scanner.nextLine();

        System.out.println(input + " in number " + convertWordsToNumbers(input));
    }
}
