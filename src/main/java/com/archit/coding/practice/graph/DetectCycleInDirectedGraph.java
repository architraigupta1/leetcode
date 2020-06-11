package com.archit.coding.practice.graph;

import com.archit.coding.utils.Graph;

public class DetectCycleInDirectedGraph {
  public static void main(String[] args) {
    int vertices = 5;
    Graph g = new Graph(vertices);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println(g.hasCycle());
  }
}
