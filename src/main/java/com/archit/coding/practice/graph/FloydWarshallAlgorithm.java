package com.archit.coding.practice.graph;

/**
 * Algo prints shortest path from every vertex to every other vertex.
 * Handles both positive and negative edges
 */
public class FloydWarshallAlgorithm {
  public static void main(String[] args) {
    int graph[][] = { {0,   5,  Integer.MAX_VALUE, 10},
        {Integer.MAX_VALUE, 0,   3, Integer.MAX_VALUE},
        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   1},
        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
    };

    FloydWarshallAlgorithm floyd = new FloydWarshallAlgorithm();
    floyd.buildshortestPaths(graph);
  }

  private void buildshortestPaths(int[][] graph) {
    int vertices = graph.length;
    int sol[][] = new int[vertices][vertices];

    //Assume that the paths between vertices are already minimum.
    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        sol[i][j] = graph[i][j];
      }
    }

    //consider every vertex has intermediate vertex
    for (int k = 0; k < vertices; k++) {
      //consider every vertex as source
      for (int i = 0; i < vertices; i++) {
        //For every source vertex, consider every other vertex as destination
        for (int j = 0; j < vertices; j++) {
          if (sol[i][k] != Integer.MAX_VALUE
              && sol[k][j] != Integer.MAX_VALUE
              && sol[i][k] + sol[k][j] < sol[i][j]) {
            sol[i][j] = sol[i][k] + sol[k][j];
          }
        }
      }
    }

    //print the solutiion
    for (int i = 0; i < vertices; i++) {
      System.out.println();
      for (int j = 0; j < vertices; j++) {
        System.out.print(sol[i][j] + " ");
      }
    }
  }
}
