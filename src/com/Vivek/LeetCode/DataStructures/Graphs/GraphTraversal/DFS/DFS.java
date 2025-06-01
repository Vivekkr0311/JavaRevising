package com.Vivek.LeetCode.DataStructures.Graphs.GraphTraversal.DFS;

import java.util.*;

import static com.Vivek.LeetCode.DataStructures.Graphs.AdjacencyList.AdjacencyList.createUndirectedGraph;

public class DFS {
    private static void dfs(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
        if (visited[u] == true) {
            return;
        }

        visited[u] = true;
        System.out.println(u);

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, v, visited);
            }
        }
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

        System.out.println("Graph adjacency list representation: ");
        Map<Integer, List<Integer>> graph = createUndirectedGraph(edges);

        // assumption is that, nodes are from 0 to n - 1, then visited array can be created like this
        boolean[] visited = new boolean[graph.keySet().size()];
        System.out.println(graph);

        dfs(graph, 0, visited);
    }
}
