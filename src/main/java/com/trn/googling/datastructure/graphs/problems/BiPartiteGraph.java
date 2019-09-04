package com.trn.googling.datastructure.graphs.problems;

import com.trn.googling.datastructure.graphs.Graph;

import java.util.LinkedList;

public class BiPartiteGraph {

    enum Color {
        RED,
        BLACK
    }

    private boolean biPartite = true;

    private boolean[] visited;

    private Color[] colors;

    public BiPartiteGraph(Graph graph){
        visited = new boolean[graph.getTotalVertices()];
        colors = new Color[graph.getTotalVertices()];

        for(int i = 0; i < graph.getTotalVertices(); i++){
            if(!visited[i]){
                dfsRecursive(graph, i, Color.RED);
            }
        }
    }

    private Color getComplimentColor(Color originalColor){
        if(originalColor.equals(Color.RED)){
            return Color.BLACK;
        }

        return Color.RED;
    }

    public void dfsRecursive(Graph graph, int source, Color sourceColor){
        //mark visited & assign color
        visited[source] = true;
        colors[source] = sourceColor;

        LinkedList<Integer> adjacencyList = graph.getAdjacencyListArray()[source];

        for(int neighbours : adjacencyList){
            if(!visited[neighbours]){
                dfsRecursive(graph, neighbours, getComplimentColor(sourceColor));
            } else {
                if(colors[neighbours].equals(sourceColor)){
                    biPartite = false;
                    System.out.println("Graph is not biPartite as vertex `"+neighbours + "` has color : `"+ colors[neighbours] + "` and vertex `"+ source + "` has color `"+ "` `"+ sourceColor);
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(10); // 5 vertices numbered from 0 to 4

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 8);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(8, 9);
        graph.addEdge(2, 4); // including this means graph is not biPartite , removing it makes the graph bipartite

        BiPartiteGraph biPartiteGraph = new BiPartiteGraph(graph);
        System.out.println("Graph is biPartite => "+ biPartiteGraph.biPartite);

    }

}
