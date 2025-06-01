package com.Vivek.LeetCode.DataStructures.Graphs.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCostWalkInWeightedGraph_3801 {
    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    private static void union(int x, int y, int[] parent) {
        parent[y] = x;
    }

    private static int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] cost = new int[n];
        Arrays.fill(cost, -1);
        int[] result = new int[query.length];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if (parent_u != parent_v) {
                cost[parent_u] &= cost[parent_v];
                union(parent_u, parent_v, parent);
            }

            cost[parent_u] &= w;
        }

        for (int i = 0; i < query.length; i++) {
            int s = query[i][0];
            int t = query[i][1];

            int p1 = find(s, parent);
            int p2 = find(t, parent);

            if (s == t)
                result[i] = 0;
            else if (p1 != p2)
                result[i] = -1;
            else
                result[i] = cost[p1];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = scanner.nextInt();

        System.out.println("Number of edges: ");
        int nE = scanner.nextInt();
        System.out.println("Enter each edge weight: ");
        int[][] edges = new int[3][nE];

        for (int i = 0; i < nE; i++) {
            int[] temp = new int[3];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            temp[2] = scanner.nextInt();
            edges[i] = temp;
        }

        System.out.println("How many queries: ");
        int m = scanner.nextInt();
        int[][] queries = new int[2][m];
        System.out.println("Enter queries: ");
        for (int i = 0; i < m; i++) {
            int[] temp = new int[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();

            queries[i] = temp;
        }

        System.out.println("Minimum weight: " + Arrays.toString(minimumCost(n, edges, queries)));
    }
}
