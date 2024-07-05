package com.Vivek.Graphs;

import java.util.ArrayList;

public class PathExistInAGraph {

    private static boolean helper(ArrayList<Integer>[] graph, int source, int destination, boolean[]visited){
        if(source == destination){
            return true;
        }

        visited[source] = true;

        for(int neighbour : graph[source]){
            if(!visited[neighbour]){
                if(helper(graph, neighbour, destination, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge :  edges){
            int v1 = edge[0];
            int v2 = edge[1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        boolean[] visited = new boolean[n];
        return helper(graph, source, destination, visited);
    }

    public static void main(String[] args) {
        int[][] g1 = {
                {0, 1},
                {2, 1},
                {2, 0}
        };

        int[][] g2 = {
                {0,1},
                {0,2},
                {3,5},
                {5,4},
                {4,3}
        };

        System.out.println("Path exist: " + validPath(3, g1, 0, 2));
        System.out.println("Path exist: " + validPath(6, g2, 0, 5));
    }
}
