package com.archit.coding.utils;

public class GraphNode {
  public int node;
  public int cost;

  public GraphNode(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }

  @Override
  public boolean equals(Object o) {

    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }

    if (!(o instanceof GraphNode)) {
      return false;
    }


    GraphNode c = (GraphNode) o;

    return c.node == this.node && c.cost == this.cost;
  }
}
