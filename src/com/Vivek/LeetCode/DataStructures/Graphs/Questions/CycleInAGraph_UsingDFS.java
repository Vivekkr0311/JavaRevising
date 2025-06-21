package com.Vivek.LeetCode.DataStructures.Graphs.Questions;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.Vivek.LeetCode.DataStructures.Graphs.AdjacencyList.AdjacencyList.createUndirectedGraph;

public class CycleInAGraph_UsingDFS {
    private static boolean DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (v == parent) {
                continue;
            }

            if (visited[v]) {
                return true;
            }

            if (DFS(adj, v, visited, u)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCycle(Map<Integer, List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        return DFS(adj, 0, visited, -1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many edges: ");
        int e = scanner.nextInt();
        int[][] edges = new int[e][2];

        System.out.println("Enter each edge: ");
        for (int i = 0; i < e; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        Map<Integer, List<Integer>> adj = createUndirectedGraph(edges);
        System.out.println("Graph adjacency list representation: ");
        System.out.println(adj);
        System.out.println("Graph has cycle: " + isCycle(adj));
    }
}