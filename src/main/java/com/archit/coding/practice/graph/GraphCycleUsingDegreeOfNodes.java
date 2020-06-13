package com.archit.coding.practice.graph;

import com.archit.coding.utils.Graph;

public class GraphCycleUsingDegreeOfNodes {
  public static void main(String[] args) {
    int vertices = 5;
    Graph g = new Graph(vertices);
    g.addUndirectedEdge(0, 1);
    g.addUndirectedEdge(0, 2);
    g.addUndirectedEdge(0, 3);
    g.addUndirectedEdge(1, 2);
    g.addUndirectedEdge(3, 4);

    g.findCycle();

  }
}
