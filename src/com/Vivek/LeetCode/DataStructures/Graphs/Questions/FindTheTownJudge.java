package com.Vivek.LeetCode.DataStructures.Graphs.Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class FindTheTownJudge {
    private static int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : trust) {
            int u = t[0];
            int v = t[1];
            graph.get(u).add(v);
        }

        for (int i = 1; i <= n; i++) {
            if (graph.get(i).isEmpty()) {
                boolean isJudge = true;
                for (int j = 1; j <= n; j++) {
                    if (j != i && !graph.get(j).contains(i)) {
                        isJudge = false;
                        break;
                    }
                }

                if (isJudge) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of vertices: ");
        int n = scanner.nextInt();
        int n1 = n;

        int[][] trust = new int[(n >> 1) + 1][2];
        System.out.println("Enter each trust relation: ");
        int idx = 0;
        while (n1 > 0) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int[] temp = new int[3];
            temp[1] = u;
            temp[2] = v;
            trust[idx++] = temp;
            n1 = n1 - 2;
        }
        System.out.println(findJudge(n, trust));
    }
}