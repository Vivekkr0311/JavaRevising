package com.Vivek.LeetCode.DataStructures.Graphs.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleInAGraph_UsingDFS_II {
    private static boolean isCycleDFS(List<List<Integer>> adj, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (v == parent) {
                continue;
            }

            if (visited[v]) {
                return true;
            }

            if (isCycleDFS(adj, v, visited, u)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v] && isCycleDFS(adj, v, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many vertices: ");
        int v = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            System.out.println(i + "'s number of next vertices: ");
            int n = scanner.nextInt();
            for (int k = 0; k < n; k++) {
                System.out.println("next vertex: ");
                temp.add(scanner.nextInt());
            }
            adj.add(temp);
        }

        System.out.println("Graph has cycle: " + isCycle(v, adj));
    }
}