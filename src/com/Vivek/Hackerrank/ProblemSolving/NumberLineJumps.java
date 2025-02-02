package com.Vivek.Hackerrank.ProblemSolving;

import java.util.Scanner;

public class NumberLineJumps {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2) {
            if (x1 == x2) {
                return "YES"; // Same start, same velocity
            } else {
                return "NO";  // Different start, same velocity; they will never meet
            }
        }

        // Check if they meet at the same position after the same number of jumps
        int distanceDifference = x2 - x1;
        int velocityDifference = v1 - v2;

        if (distanceDifference * velocityDifference < 0) {
            return "NO"; // Moving apart
        }

        if (distanceDifference % velocityDifference == 0) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter position of first kangaroo: ");
        int x1 = scanner.nextInt();
        System.out.println("Enter velocity of first kangaroo: ");
        int v1 = scanner.nextInt();

        System.out.println("Enter position of second kangaroo: ");
        int x2 = scanner.nextInt();
        System.out.println("Enter velocity of second kangaroo: ");
        int v2 = scanner.nextInt();

        String ans = kangaroo(x1, v1, x2, v2);
        System.out.println(ans);
    }
}
