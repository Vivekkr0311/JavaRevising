package com.Vivek.LeetCode.DataStructures.Graphs;

import java.util.Queue;
import java.util.LinkedList;

public class DetectCycleUsingBFS {
    private static boolean isCycleBFS(int[][] adj, int u, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{u, -1});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curr = node[0];
            int parent = node[1];

            for (int neighbor : adj[curr]) {
                if (!visited[neighbor]) {
                    queue.offer(new int[]{neighbor, curr});
                    visited[neighbor] = true;
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int V, int[][] adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleBFS(adj, i, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        int[][] adj = new int[V][];
        adj[0] = new int[]{1, 2};
        adj[1] = new int[]{0, 2};
        adj[2] = new int[]{0, 1, 3};
        adj[3] = new int[]{2};

        System.out.println(isCycle(V, adj));
    }
}
