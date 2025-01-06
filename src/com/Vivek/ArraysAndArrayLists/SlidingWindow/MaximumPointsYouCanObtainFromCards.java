package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MaximumPointsYouCanObtainFromCards {
    private static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i <= k - 1; i++) {
            sum = sum + cardPoints[i];
        }

        if (cardPoints.length == k) {
            return sum;
        }

        int leftSum = sum;
        int rightSum = 0;
        int rightIdx = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rightIdx--];

            int currSum = leftSum + rightSum;
            if (currSum > sum) {
                sum = currSum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of cards: ");
        int n = scanner.nextInt();

        int[] cardPoints = new int[n];
        System.out.println("Enter point of each card: ");
        for (int i = 0; i < n; i++) {
            cardPoints[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Maximum score we can get if we pick up " + k + " cards is " + maxScore(cardPoints, k));
    }
}
