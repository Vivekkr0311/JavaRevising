package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=false
public class SubarrayDivision {
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int ans = 0;
        for (int i = 0; i <= s.size() - m; i++) {
            int currSum = 0;
            for (int j = i; j < i + m; j++) {
                currSum += s.get(j);
            }

            if (currSum == d) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of bars in the chocolate: ");
        int n = scanner.nextInt();

        List<Integer> bar = new ArrayList<>();
        System.out.println("Enter each bar number: ");
        for (int i = 0; i < n; i++) {
            bar.add(scanner.nextInt());
        }

        System.out.println("Enter the birthday: ");
        int d = scanner.nextInt();

        System.out.println("Enter the birthday month for length of chocolate: ");
        int m = scanner.nextInt();

        System.out.println("Total possible ways to take the chocolate: " + birthday(bar, d, m));
    }
}
