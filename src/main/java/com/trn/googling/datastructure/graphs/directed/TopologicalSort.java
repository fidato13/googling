package com.trn.googling.datastructure.graphs.directed;

import java.util.Stack;

public class TopologicalSort {

    private boolean[] vistied;

    private static Stack<Integer> reversePost;

    public TopologicalSort(DiGraph diGraph) {
        this.vistied = new boolean[diGraph.getTotalVertices()];

        this.reversePost = new Stack<>();

        for(int i = 0; i < diGraph.getTotalVertices(); i++){
            if(!vistied[i])
            dfsRecursive(diGraph, i);
        }


    }

    private void dfsRecursive(DiGraph diGraph, int vertex){

        vistied[vertex] = true;

        for(int neighbour : diGraph.getAdjacencyListArray()[vertex]){
            if(!vistied[neighbour]){
                dfsRecursive(diGraph, neighbour);
            }
        }

        reversePost.push(vertex);
    }

    public static void main(String[] args) {

        // Create a graph given in the above diagram
        DiGraph g = new DiGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        new TopologicalSort(g);

        System.out.println("the stack is => "+ reversePost);
    }
}
