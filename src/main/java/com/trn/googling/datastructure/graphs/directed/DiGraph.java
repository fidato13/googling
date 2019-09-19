package com.trn.googling.datastructure.graphs.directed;

import java.util.LinkedList;

public class DiGraph {

    private int totalVertices;

    private LinkedList<Integer>[] adjacencyListArray;

    public DiGraph(int totalVertices) {
        this.totalVertices = totalVertices;

        adjacencyListArray = new LinkedList[totalVertices];

        for(int i = 0; i < totalVertices; i++){
            adjacencyListArray[i] = new LinkedList<>();
        }
    }

    // add edge in graph between two vertices
    public void addEdge(int source, int destination){
        adjacencyListArray[source].add(destination);
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public LinkedList<Integer>[] getAdjacencyListArray() {
        return adjacencyListArray;
    }
}
