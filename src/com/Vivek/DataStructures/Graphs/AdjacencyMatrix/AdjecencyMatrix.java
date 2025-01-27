package com.Vivek.DataStructures.Graphs.AdjacencyMatrix;

public class AdjecencyMatrix {

    // Adjacency Matrix:
    // Pros: Simple Structure, Efficient for dense graph, Quick edge queries
    // Cons: Space Complexity more, Expensive operations not suitable for dynamic graphs

    public static void main(String[] args) {
        Graph G = new Graph(5);

        G.addEdge(1, 2);
        G.addEdge(1, 4);
        G.addEdge(2, 3);
        G.addEdge(4, 3);
    }
}
