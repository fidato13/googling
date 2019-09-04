package com.trn.googling.datastructure.graphs.problems;

import com.trn.googling.datastructure.graphs.Graph;

import java.util.LinkedList;

public class UndirectedGraphCycle {

    private boolean[] visited;

    private boolean cycle = false;

    public UndirectedGraphCycle(Graph graph){
        visited = new boolean[graph.getTotalVertices()];

        for(int i = 0; i < graph.getTotalVertices(); i++){
            if(!visited[i]){
                dfsRecursive(graph, i, -1);
            }

        }
    }

    public void dfsRecursive(Graph graph, int source, int parent){
        visited[source] = true;

        LinkedList<Integer> adjacencyList = graph.getAdjacencyListArray()[source];

        for(int adjacentVertex : adjacencyList){
            if(!visited[adjacentVertex]){
                dfsRecursive(graph, adjacentVertex, source);
            } else {
                if(parent != adjacentVertex){
                    cycle = true;
                    System.out.println("Cycle detected!!, parent => "+ parent + " , adjacent => "+ adjacentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(13); // 5 vertices numbered from 0 to 4

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 9);
        graph.addEdge(5, 10);
        graph.addEdge(4, 7);
        graph.addEdge(4, 8);
        graph.addEdge(7, 11);
        graph.addEdge(7, 12);
        graph.addEdge(6, 10);

        UndirectedGraphCycle undirectedGraphCycle = new UndirectedGraphCycle(graph);
        System.out.println("Cycle ??? => "+ undirectedGraphCycle.cycle);
    }
}
