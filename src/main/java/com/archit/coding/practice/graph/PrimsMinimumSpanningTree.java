package com.archit.coding.practice.graph;

import com.archit.coding.utils.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimsMinimumSpanningTree {

  int vertices;
  List<LinkedList<GraphNode>> adj;
  int[] parent;
  int[] dist;
  Set<Integer> mst;

  public PrimsMinimumSpanningTree(int vertices) {
    this.vertices = vertices;
    this.adj = new ArrayList<>();
    this.parent = new int[this.vertices];
    this.dist = new int[this.vertices];
    this.mst = new HashSet();

    for (int i = 0; i < this.vertices; i++) {
      this.adj.add(new LinkedList<>());
      this.dist[i] = Integer.MAX_VALUE;
    }
  }

  public static void main(String[] args) {
    int vertices = 9;
    PrimsMinimumSpanningTree prims = new PrimsMinimumSpanningTree(vertices);
    prims.initGraph();
    prims.makeMst(0);
    prims.printMst(0);

  }

  private void printMst(int source) {
    for (int i = 1; i < this.vertices; i++) {
      System.out.println("Edge " + i + "-->" + parent[i] + " with distance " + dist[i]);
    }
  }

  private void print(int i) {
    if (parent[i] == -1) {
      return;
    }
    print(parent[i]);
    System.out.print(i + " ");
  }

  private void makeMst(int source) {
    this.dist[source] = 0;
    this.parent[source] = -1;

    PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> {
      if (a.cost <= b.cost) {
        return -1;
      } else if (a.cost > b.cost) {
        return 1;
      } else {
        return 0;
      }
    });

    pq.add(new GraphNode(source, dist[source]));

    while(mst.size() != this.vertices - 1) {
      GraphNode settled = pq.poll();

      updateAdjacentVertices(pq, settled);

      mst.add(settled.node);
    }
  }

  private void updateAdjacentVertices(PriorityQueue<GraphNode> pq, GraphNode settled) {
    Iterator<GraphNode> it = this.adj.get(settled.node).iterator();
    while (it.hasNext()) {
      GraphNode next = it.next();

      if (!this.mst.contains(next.node)) {
        int edge = next.cost;
        if (this.dist[next.node] > edge) {
          this.dist[next.node] = edge;
          this.parent[next.node] = settled.node;
          pq.add(new GraphNode(next.node, dist[next.node]));
        }
      }
    }
  }

  private void initGraph() {
    adj.get(0).add(new GraphNode(1, 4));
    adj.get(0).add(new GraphNode(7, 8));
    adj.get(1).add(new GraphNode(2, 8));
    adj.get(1).add(new GraphNode(7, 11));
    adj.get(2).add(new GraphNode(3, 7));
    adj.get(2).add(new GraphNode(8, 2));
    adj.get(2).add(new GraphNode(5, 4));
    adj.get(3).add(new GraphNode(4, 9));
    adj.get(3).add(new GraphNode(5, 14));
    adj.get(4).add(new GraphNode(5, 10));
    adj.get(5).add(new GraphNode(6, 2));
    adj.get(6).add(new GraphNode(7, 1));
    adj.get(6).add(new GraphNode(8, 6));
    adj.get(7).add(new GraphNode(8, 7));
  }
}
