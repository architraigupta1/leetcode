package com.archit.coding.practice.graph;

import com.archit.coding.utils.Graph;

public class TopologicalSorting {
  public static void main(String[] args) {
    int vertices = 6;
    Graph g = new Graph(vertices);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.topologicalSort();
  }
}
