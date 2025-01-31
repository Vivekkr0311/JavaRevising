package com.Vivek.Hackerrank.ProblemSolving;

import java.util.Scanner;

public class TimeInWords {
    private static String timeInWords(int h, int m) {
        String[] words = {
                "o' clock", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five",
                "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "half"
        };

        if (m == 0) {
            return words[h] + " " + words[0];
        } else {
            if (m == 15) {
                return "quarter past " + words[h];
            } else if (m == 30) {
                return "half past " + words[h];
            } else if (m == 45) {
                return "quarter to " + words[h % 12 + 1];
            } else if (m < 30) {
                return words[m] + " minutes past " + words[h];
            } else {
                int remainingMinutes = 60 - m;
                return words[remainingMinutes] + " minutes to " + words[h % 12 + 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);

        System.out.println(time + " in words: " + timeInWords(h, m));
    }
}
