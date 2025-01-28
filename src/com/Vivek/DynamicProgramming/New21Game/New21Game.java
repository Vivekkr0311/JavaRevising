package com.Vivek.DynamicProgramming.New21Game;

import java.util.ArrayList;
import java.util.Scanner;

public class New21Game {
    private static double new21Game(int n, int k, int maxPts) {
        ArrayList<Double> P = new ArrayList<>();

        P.add(1.0);

        for (int i = 1; i <= n; i++) {
            double currentProbability = 0.0;

            // Calculate the probability for point `i`
            for (int card = 1; card <= maxPts; card++) {
                if (i - card >= 0 && i - card < k) {
                    double probabilityOfCurrentCard = 1.0 / maxPts;
                    currentProbability += P.get(i - card) * probabilityOfCurrentCard;
                }
            }

            P.add(currentProbability);
        }

        double result = 0.0;
        for (int i = k; i < P.size(); i++) {
            result += P.get(i);
        }
        return result;
    }

    public static double new21GameDP(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1]; // DP array to store probabilities
        dp[0] = 1.0;                     // Base case: start with 0 points
        double windowSum = 1.0;          // Sum of probabilities in the sliding window
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                windowSum += dp[i];      // Accumulate probabilities while i < k
            } else {
                result += dp[i];         // Add to the result if i >= k
            }

            if (i >= maxPts) {
                windowSum -= dp[i - maxPts]; // Remove the leftmost element from the window
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Enter k: ");
        int k = scanner.nextInt();
        System.out.println("Enter maxPts: ");
        int maxPts = scanner.nextInt();

        System.out.println("Probability: " + new21Game(n, k, maxPts));
        System.out.println("Probability: " + new21GameDP(n, k, maxPts));
    }
}
