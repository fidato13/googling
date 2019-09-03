package com.trn.googling.datastructure.graphs;

import java.util.Iterator;

/**
 * A dfs is basically recursively visiting all adjacent nodes from a given vertex and also not to visit a node again which was already visited
 */
public class DFSGraph {

    // this helps in identifying which vertices have been visited already
    private boolean[] visited;

    public DFSGraph(Graph graph, int source){
        visited = new boolean[graph.getTotalVertices()];
        dfsRecursive(graph, source);
    }

    public void dfsRecursive(Graph graph, int vertex){
        visited[vertex] = true;

        System.out.print(vertex+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> iterator = graph.getAdjacencyListArray()[vertex].listIterator();

        while(iterator.hasNext()){
            int newVertex = iterator.next();
            if(!visited[newVertex]){
                dfsRecursive(graph, newVertex);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        DFSGraph dfsGraph = new DFSGraph(graph, 2);
    }

}
