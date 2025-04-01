package com.Vivek.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SolvingQuestionsWithBrainpower_2140 {
    private static long helper(int[][] questions, int questionNumber) {
        if (questionNumber == questions.length - 1) {
            return questions[questionNumber][0];
        }

        if (questionNumber >= questions.length) {
            return 0;
        }

        long currQuestionSolved = questions[questionNumber][0] + helper(questions, questionNumber + questions[questionNumber][1] + 1);
        long skipCurrQuestion = helper(questions, questionNumber + 1);
        return Math.max(currQuestionSolved, skipCurrQuestion);
    }

    private static long mostPointsRecursion(int[][] questions) {
        return helper(questions, 0);
    }

    private static long helperMemoization(int[][] questions, int questionNumber, long[] table) {
        if (questionNumber == questions.length - 1) {
            return questions[questionNumber][0];
        }

        if (questionNumber >= questions.length) {
            return 0;
        }

        if (table[questionNumber] != -1) {
            return table[questionNumber];
        }

        long currQuestionSolved = questions[questionNumber][0] + helperMemoization(questions, questionNumber + questions[questionNumber][1] + 1, table);
        long skipCurrQuestion = helperMemoization(questions, questionNumber + 1, table);
        table[questionNumber] = Math.max(currQuestionSolved, skipCurrQuestion);
        return table[questionNumber];
    }

    private static long mostPointsRecursionMemoization(int[][] questions) {
        long[] table = new long[questions.length];
        Arrays.fill(table, -1);
        return helperMemoization(questions, 0, table);
    }

    private static long mostPointsDp(int[][] questions) {
        int n = questions.length;
        if (n == 1) {
            return questions[0][0];
        }

        long[] table = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int nextIndex = i + questions[i][1] + 1;
            long solve = questions[i][0] + (nextIndex < n ? table[nextIndex] : 0);
            long skip = (i < n - 1) ? table[i + 1] : 0;
            table[i] = Math.max(skip, solve);
        }
        return table[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of question: ");
        int n = scanner.nextInt();
        int[][] questions = new int[n][2];

        System.out.println("Enter each question points and brainpower: ");
        for (int i = 0; i < n; i++) {
            questions[i][0] = scanner.nextInt();
            questions[i][1] = scanner.nextInt();
        }

        System.out.println("Maximum points: " + mostPointsRecursion(questions));
        System.out.println("Maximum points: " + mostPointsRecursionMemoization(questions));
        System.out.println("Maximum points: " + mostPointsDp(questions));
    }
}