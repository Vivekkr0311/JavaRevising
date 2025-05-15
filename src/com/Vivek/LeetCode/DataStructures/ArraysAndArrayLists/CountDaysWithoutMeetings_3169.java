package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class CountDaysWithoutMeetings_3169 {
    private static int countDays(int days, int[][] meetings){
        boolean[] flags = new boolean[days];

        for(int[] arr : meetings){
            int start = arr[0];
            int end = arr[1];

            for(int i = start -1; i < end; i++){
                flags[i] = true;
            }
        }

        int result = 0;
        for(boolean f : flags){
            if(!f){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter days: ");
        int days = scanner.nextInt();

        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Enter meetings: ");
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = scanner.nextInt();
            meetings[i][1] = scanner.nextInt();
        }

        System.out.println("Result: " + countDays(days, meetings));
    }
}
