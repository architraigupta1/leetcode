package com.archit.coding.practice.graph;

import com.archit.coding.utils.GraphNode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgorithm {

  int vertices;
  List<LinkedList<GraphNode>> adj;
  int parent[];
  int dist[];
  Set<Integer> settled;

  public DijkstraAlgorithm(int vertices) {
    this.vertices = vertices;
    this.adj = new ArrayList<>(this.vertices);
    this.parent = new int[this.vertices];
    this.dist = new int[this.vertices];
    this.settled = new HashSet<>(this.vertices);

    for (int i = 0; i < this.vertices; i++) {
      this.adj.add(new LinkedList<>());
      dist[i] = Integer.MAX_VALUE;
    }
  }

  public static void main(String[] args) {
    int vertices = 5;
    DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(vertices);
    dijkstraAlgorithm.initGraph();

    int source = 0;
    dijkstraAlgorithm.performDijkstra(source);
    dijkstraAlgorithm.printShortestPath(source);

  }

  private void printShortestPath(int source) {
    for (int i = 0; i < this.vertices; i++) {
      System.out.print("Cost of Path from source " + source + " to " + i + " is " + dist[i] + " Path is ");
      printPath(i);
      System.out.println();
    }
  }

  private void printPath(int node) {
    if (parent[node] == -1) {
      return;
    }
    printPath(parent[node]);
    System.out.print(node + " ");
  }

  private void performDijkstra(int source) {
    this.parent[source] = -1;
    this.dist[source] = 0;
    PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> {
      if (a.cost <= b.cost) {
        return -1;
      } else if (a.cost > b.cost) {
        return 1;
      } else {
        return 0;
      }
    });
    pq.add(new GraphNode(0, 0));

    while (this.settled.size() != this.vertices) {
      GraphNode settledVertex = pq.poll();

      this.settled.add(settledVertex.node);

      updateAdjacentVerticesDistance(pq, settledVertex);
    }
  }

  private void updateAdjacentVerticesDistance(PriorityQueue<GraphNode> pq, GraphNode settledVertex) {
    Iterator<GraphNode> it = this.adj.get(settledVertex.node).iterator();
    while (it.hasNext()) {
      GraphNode next = it.next();
      int edge = next.cost;
      int settledVertexCost = dist[settledVertex.node];
      if (!settled.contains(next.node)) {
        if (dist[next.node] > settledVertexCost + edge) {
          dist[next.node] = settledVertexCost + edge;
          parent[next.node] = settledVertex.node;
          pq.add(new GraphNode(next.node, dist[next.node]));
        }
      }

    }
  }

  private void initGraph() {
    adj.get(0).add(new GraphNode(1, 9));
    adj.get(0).add(new GraphNode(2, 6));
    adj.get(0).add(new GraphNode(3, 5));
    adj.get(0).add(new GraphNode(4, 3));

    adj.get(2).add(new GraphNode(1, 2));
    adj.get(2).add(new GraphNode(3, 4));
  }
}

