package com.Vivek.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DirectedGraph {

    private int[] vertices;
    private ArrayList<ArrayList<Integer>> adjacent_List;
    private HashMap<Integer, ArrayList<Integer>> graph;
    private Scanner scanner;

    public DirectedGraph() {
        this.scanner = new Scanner(System.in);
        this.adjacent_List = new ArrayList<>();
        this.graph = new HashMap<>();
    }

    public void printGraph() {
        for (int v : vertices) {
            System.out.println("Vertex: " + v + " is connected to: " + graph.get(v));
        }
    }

    public ArrayList<ArrayList<Integer>> getAdjacent_List() {
        return this.adjacent_List;
    }

    public int[] getVertices(){
        return this.vertices;
    }

    public void setVertices() {
        System.out.println("Enter number of vertices: ");
        int n = scanner.nextInt();

        vertices = new int[n];
        System.out.println("Enter each vertex: ");
        for (int i = 0; i < n; i++) {
            vertices[i] = scanner.nextInt();
        }
        System.out.println("Vertices created: " + Arrays.toString(vertices));
    }

    public void createGraph() {
        if (vertices.length == 0) {
            System.out.println("Create vertices first");
            return;
        }

        Scanner s = new Scanner(System.in);
        for (int i : vertices) {
            System.out.println("Do you want to add vertices to " + i + "? (true/false)");
            boolean flag = s.nextBoolean();

            ArrayList<Integer> currList = new ArrayList<>();
            while (flag) {
                System.out.println("Enter the adjacent vertex to " + i + " (-1 to stop):");
                int adjVertex = s.nextInt();

                if (adjVertex == -1) { // Stop adding neighbors
                    break;
                }

                currList.add(adjVertex); // Add the adjacent vertex
            }

            adjacent_List.add(currList); // Add the current list to the adjacency list
            graph.put(i, currList);      // Add to the graph map
        }
        s.close();
    }
}