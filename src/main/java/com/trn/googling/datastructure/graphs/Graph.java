package com.trn.googling.datastructure.graphs;

import java.util.LinkedList;

/**
 * Graph class to represent a graph in memory
 */
public class Graph {

    /**
     * How many total vertices are there in this graph
     */
    private int totalVertices;

    // an array of linkedList to represent our adjacency list representation.
    private LinkedList<Integer>[] adjacencyListArray;

    public Graph(int vertices){
        this.totalVertices = vertices;

        // define the size of array as
        // number of vertices
        adjacencyListArray = new LinkedList[vertices];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 0; i < vertices; i++){
            adjacencyListArray[i] = new LinkedList<>();
        }

    }

    // add edge in graph between two vertices
    public void addEdge(int source, int destination){
        adjacencyListArray[source].add(destination);

        //for undirected Graphs
        adjacencyListArray[destination].add(source);
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public LinkedList<Integer>[] getAdjacencyListArray() {
        return adjacencyListArray;
    }
}
