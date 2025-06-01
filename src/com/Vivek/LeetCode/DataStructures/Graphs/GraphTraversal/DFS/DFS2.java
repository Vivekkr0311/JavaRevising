package com.Vivek.LeetCode.DataStructures.Graphs.GraphTraversal.DFS;

import java.util.*;

import static com.Vivek.LeetCode.DataStructures.Graphs.AdjacencyList.AdjacencyList.createUndirectedGraph;

public class DFS2 {
    private static void dfs(Map<Integer, List<Integer>> adj, int u, HashSet<Integer> visited) {
        if (visited.contains(u)) {
            return;
        }

        visited.add(u);
        System.out.println(u);

        for (var v : adj.get(u)) {
            if (!visited.contains(v)) {
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
        HashSet<Integer> nodes = new HashSet<>();

        for (int i = 0; i < e; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();

            if (!nodes.contains(edges[i][0])) {
                nodes.add(edges[i][0]);
            }
            if (!nodes.contains(edges[i][1])) {
                nodes.add(edges[i][1]);
            }
        }

        System.out.println("Graph adjacency list representation: ");
        Map<Integer, List<Integer>> graph = createUndirectedGraph(edges);

        System.out.println("Select the start node: " + nodes);
        int startNode = scanner.nextInt();
        if (!nodes.contains(startNode)) {
            System.out.println("This node does not exist.");
            System.exit(0);
        }

        HashSet<Integer> visited = new HashSet<>();
        System.out.println("Traversing undirected graph: ");
        dfs(graph, startNode, visited);
    }
}