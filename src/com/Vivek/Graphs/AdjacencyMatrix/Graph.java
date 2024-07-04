package com.Vivek.Graphs.AdjacencyMatrix;

public class Graph {

    private int adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    Graph(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add edge
    public void addEdge(int i, int j){
        this.adjMatrix[i][j] = 1;
        this.adjMatrix[j][i] = 1;
    }

    // Remove Edge
    public void removeEdge(int i, int j){
        this.adjMatrix[i][j] = 0;
        this.adjMatrix[j][i] = 0;
    }

    // Add Vertex
    public void addVertex(){
        int[][] newAdjMatrix = new int[this.numVertices + 1][this.numVertices + 1];

        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                newAdjMatrix[i][j] = this.adjMatrix[i][j];
            }
        }

        this.adjMatrix = newAdjMatrix;
        numVertices++;
    }

    // Remove Vertex
    public void removeVertex(int v){
        int[][] newAdjMatrix = new int[this.numVertices - 1][this.numVertices - 1];

        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                if(i != v && j != v){
                    newAdjMatrix[i][j] = this.adjMatrix[i][j];
                }
            }
        }

        this.adjMatrix = newAdjMatrix;
        numVertices--;
    }
}
