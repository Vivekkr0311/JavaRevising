package com.Vivek.Hackerrank.ProblemSolving;

import java.util.Scanner;

public class TimeConversion {
    private static String timeConversion(String s) {
        String[] parts = s.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        String secondsAndMeridiem = parts[2];
        String meridiem = secondsAndMeridiem.substring(2);
        int second = Integer.parseInt(secondsAndMeridiem.substring(0, 2));

        if (meridiem.equalsIgnoreCase("AM")) {
            hour = (hour == 12) ? 0 : hour;
        } else {
            hour = (hour == 12) ? 12 : hour + 12;
        }
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter time in 12-hr format: ");
        String time = scanner.nextLine();

        System.out.println("Time in military format: " + timeConversion(time));
    }
}
