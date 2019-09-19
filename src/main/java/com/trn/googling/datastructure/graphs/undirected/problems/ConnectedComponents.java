package com.trn.googling.datastructure.graphs.undirected.problems;

import com.trn.googling.datastructure.graphs.undirected.Graph;

import java.util.LinkedList;

/**
 * Other Problems:
 *  1. If a graph is bipartite
 *  2. Graph contains a cycle or not
 *  3. Find a (General) cycle that uses every edge exactly once
 *  4. Find a cycle that visits every vertex exactly once
 *
 */
public class ConnectedComponents {

    private boolean[] visited;
    private int[] connectedComponentId;
    private int count = 0;

    public ConnectedComponents(Graph graph) {

        visited = new boolean[graph.getTotalVertices()];
        connectedComponentId = new int[graph.getTotalVertices()];

        for(int i = 0; i < graph.getTotalVertices(); i++){
            if(!visited[i]){
                dfsRecursive(graph, i);
                count++;
            }
        }

    }

    private void dfsRecursive(Graph graph, int source){
        visited[source] = true;
        LinkedList<Integer> adjacencyList = graph.getAdjacencyListArray()[source];
        for(int i = 0; i < adjacencyList.size(); i++){
            if(!visited[adjacencyList.get(i)]){
                dfsRecursive(graph, adjacencyList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph graph = new Graph(5); // 5 vertices numbered from 0 to 4

        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        ConnectedComponents connectedComponents = new ConnectedComponents(graph);
        System.out.println("Following are connected components => "+ (connectedComponents.count));

    }
}
