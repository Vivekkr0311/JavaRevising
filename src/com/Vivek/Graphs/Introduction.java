package com.Vivek.Graphs;

// There are two ways to represent a Graph data structure:
// 1. Using Adjacency matrix: In this way of representing a graph we use 2-D array, where indexes represents a vertex,
//                            and value at any specific place will represent the weight of connecting vertices.
//                            This way is only possible when number of vertices is less than 10,000
//                           eg:   a, b, c, d
//                              a: [0, 1, 2, 0]
//                              b: [1, 0, 2, 0]
//                              c: [2, 2, 0, 3]
//                              d: [0, 0, 3, 0]

//                                       a
//                                      / \
//                                     1   2
//                                    /     \
//                                   b---2---c
//                                          /
//                                         3
//                                        /
//                                       d


// 2. Using Arraylist: We make list which represents edges.

import java.util.ArrayList;

public class Introduction {

    static class Edge {
        private int source;
        private int neighbour;
        private int weight;

        public Edge(int source, int neighbour, int weight){
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // Arraylist representation implementation
        int numberOfVertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));
    }
}
