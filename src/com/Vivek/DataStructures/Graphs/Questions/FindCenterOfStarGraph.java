package com.Vivek.DataStructures.Graphs.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FindCenterOfStarGraph {
    private static int findCenter(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int key : graph.keySet()) {
            System.out.println(key + " => " + graph.get(key));
        }

        for (int key : graph.keySet()) {
            if (graph.get(key).size() == edges.length) {
                return key;
            }
        }
        return -1;
    }

    private static int findCenterSpaceOptimized(int[][] edges) {
        HashMap<Integer, Integer> graph = new HashMap<>();

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            graph.put(u, graph.getOrDefault(u, 0) + 1);
            graph.put(v, graph.getOrDefault(v, 0) + 1);
        }

        for (int key : graph.keySet()) {
            System.out.println(key + " => " + graph.get(key));
        }

        for (int key : graph.keySet()) {
            if (graph.get(key) == edges.length) {
                return key;
            }
        }
        return -1;
    }

    private static int findCenterTimeAndSpaceOptimized(int[][] edges) {
        int[] first_edge = edges[0];
        int[] second_edge = edges[1];

        if (first_edge[0] == second_edge[0] || first_edge[0] == second_edge[1]) {
            return first_edge[0];
        } else if (first_edge[1] == second_edge[0] || first_edge[1] == second_edge[1]) {
            return first_edge[1];
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of edges: ");
        int n = scanner.nextInt();
        int[][] edges = new int[n][2];

        System.out.println("Enter each edge: ");
        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            edges[i][0] = u;
            edges[i][1] = v;
        }

        int res = findCenter(edges);
        int res2 = findCenterSpaceOptimized(edges);
        int res3 = findCenterTimeAndSpaceOptimized(edges);
        System.out.println("Center node is: " + res);
        System.out.println("Center node is: " + res2);
        System.out.println("Center node is: " + res3);
    }
}