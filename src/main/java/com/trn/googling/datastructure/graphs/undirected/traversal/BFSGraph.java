package com.trn.googling.datastructure.graphs.undirected.traversal;

import com.trn.googling.datastructure.graphs.undirected.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Breath first Search for a graph is visiting a node followed by immediately visiting ALL of it adjacent nodes (without going to their adjacent nodes) and so on , level by level
 */
public class BFSGraph {

    private boolean[] visited;

    public BFSGraph(Graph graph, int source){
        visited = new boolean[graph.getTotalVertices()];
        bfs(graph, source);
    }

    private void bfs(Graph graph, int vertex){
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while(queue.size() != 0){

            //remove a vertex from the queue
            int currentVertex = queue.poll();

            //print the vertex
            System.out.print(currentVertex+" ");

            //get all adjacent vertices
            Iterator<Integer> iterator = graph.getAdjacencyListArray()[currentVertex].listIterator();

            while(iterator.hasNext()){
                int adjacentVertex = iterator.next();

                //if they are not already visited, put them into the queue for visiting later
                if(!visited[adjacentVertex]){
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
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

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        BFSGraph bfsGraph = new BFSGraph(graph, 2);

    }

}
