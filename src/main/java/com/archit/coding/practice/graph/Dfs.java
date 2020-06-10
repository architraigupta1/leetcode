package com.archit.coding.practice.graph;

import com.archit.coding.utils.Graph;

public class Dfs {
  public static void main(String[] args) {
    int vertices = 4;
    Graph g = new Graph(vertices);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    boolean[] visited = new boolean[vertices];

    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) {
        g.dfs(i, visited);
      }
    }
  }
}
