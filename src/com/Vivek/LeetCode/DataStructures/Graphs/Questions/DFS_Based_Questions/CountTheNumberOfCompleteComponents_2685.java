package com.Vivek.LeetCode.DataStructures.Graphs.Questions.DFS_Based_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountTheNumberOfCompleteComponents_2685 {
    private static void dfs(int curr, int[] nodes, int[] edges, List<List<Integer>> adj, boolean[] visited) {
        nodes[0]++;
        visited[curr] = true;
        for (int nbr : adj.get(curr)) {
            edges[0]++;
            if (!visited[nbr]) {
                dfs(nbr, nodes, edges, adj, visited);
            }
        }
    }

    private static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int completeComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] nodes = new int[1];
                int[] edgesCount = new int[1];
                dfs(i, nodes, edgesCount, adj, visited);
                if (edgesCount[0] == nodes[0] * (nodes[0] - 1)) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = scanner.nextInt();

        System.out.println("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();
        int[][] edges = new int[numberOfEdges][2];

        System.out.println("Enter each edge: ");
        for (int i = 0; i < numberOfEdges; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        System.out.println("Number of complete components are: " + countCompleteComponents(n, edges));
    }
}
