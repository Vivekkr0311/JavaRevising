package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=false
public class BreakingTheRecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int numberOfMinScoreBreaked = 0;
        int numberOfMaxScoreBreaked = 0;

        int fMin = scores.get(0);
        int fMax = scores.get(0);

        for (int i = 1; i < scores.size(); i++) {
            if (fMin > scores.get(i)) {
                fMin = scores.get(i);
                numberOfMinScoreBreaked++;
            }
        }

        for (int i = 1; i < scores.size(); i++) {
            if (fMax < scores.get(i)) {
                fMax = scores.get(i);
                numberOfMaxScoreBreaked++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(numberOfMaxScoreBreaked);
        ans.add(numberOfMinScoreBreaked);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of games: ");
        int n = scanner.nextInt();

        List<Integer> scores = new ArrayList<>();
        System.out.println("Enter each scores: ");
        for (int i = 0; i < n; i++) {
            scores.add(scanner.nextInt());
        }

        System.out.println("Number of times record breaked: " + breakingRecords(scores));
    }
}
