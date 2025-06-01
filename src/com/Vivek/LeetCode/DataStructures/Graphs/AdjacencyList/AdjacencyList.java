package com.Vivek.LeetCode.DataStructures.Graphs.AdjacencyList;

import java.util.*;

public class AdjacencyList {
    public static Map<Integer, List<Integer>> createUndirectedGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

            // for undirected graph, in case of directed just remove the below line
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return graph;
    }

    public static Map<Integer, List<Integer>> createDirectedGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        return graph;
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
        System.out.println(createUndirectedGraph(edges));
    }
}