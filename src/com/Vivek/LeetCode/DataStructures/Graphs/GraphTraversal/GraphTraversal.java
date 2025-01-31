package com.Vivek.LeetCode.DataStructures.Graphs.GraphTraversal;

import com.Vivek.LeetCode.DataStructures.Graphs.DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    private static ArrayList<Integer> graphDFS(int[] vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();

        boolean[] visited = new boolean[vertices.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertices[0]);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            bfsTraversal.add(u);

            for (int v : adjacencyList.get(u)) {
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        return bfsTraversal;
    }

    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.setVertices();
        directedGraph.createGraph();
        directedGraph.printGraph();

        int[] vertices = directedGraph.getVertices();
        ArrayList<ArrayList<Integer>> adjacencyList = directedGraph.getAdjacent_List();

        ArrayList<Integer> bfsTraversal = graphDFS(vertices, adjacencyList);
        System.out.println("BFS traversal: " + bfsTraversal);
    }
}
