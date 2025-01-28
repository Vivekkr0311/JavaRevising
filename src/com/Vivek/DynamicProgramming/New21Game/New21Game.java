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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Enter k: ");
        int k = scanner.nextInt();
        System.out.println("Enter maxPts: ");
        int maxPts = scanner.nextInt();

        System.out.println("Probability: " + new21Game(n, k, maxPts));
    }
}
