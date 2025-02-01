package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppleAndOrange {
    private static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int[] allAppleDistances = new int[apples.size()];
        int[] allOrangeDistances = new int[oranges.size()];

        for (int i = 0; i < apples.size(); i++) {
            allAppleDistances[i] = apples.get(i) + a;
        }

        for (int i = 0; i < oranges.size(); i++) {
            allOrangeDistances[i] = oranges.get(i) + b;
        }

        int applesInRange = 0;
        for (int r : allAppleDistances) {
            if (r >= s && r <= t) {
                applesInRange++;
            }
        }

        int orangesInRange = 0;
        for (int r : allOrangeDistances) {
            if (r >= s && r <= t) {
                orangesInRange++;
            }
        }

        System.out.println(applesInRange);
        System.out.println(orangesInRange);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter position of house (s and t):");
        int s = scanner.nextInt();
        int t = scanner.nextInt();

        System.out.println("Enter the position of tree (a and b): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("Enter number of fruits in apple tree: ");
        int m = scanner.nextInt();

        System.out.println("Enter number of fruits in orange tree: ");
        int n = scanner.nextInt();

        System.out.println("Enter distance of from apple tree: ");
        List<Integer> apples = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            apples.add(scanner.nextInt());
        }

        System.out.println("Enter distance of from orange tree: ");
        List<Integer> oranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            oranges.add(scanner.nextInt());
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}
