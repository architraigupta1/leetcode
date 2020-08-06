package com.archit.coding.practice.graph;

import com.archit.coding.utils.GraphEdge;
import com.archit.coding.utils.GraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumWeightCycleInUndirectedGraph {

  int vertices;
  int [] parent;
  int [] dist;
  List<LinkedList<GraphNode>> adj;
  List<GraphEdge> edges;
  Set<Integer> settled;

  public MinimumWeightCycleInUndirectedGraph(int vertices) {
    this.vertices = vertices;
    this.parent = new int[this.vertices];
    this.dist = new int[this.vertices];
    this.adj = new ArrayList<>(this.vertices);
    this.edges = new ArrayList<>();
    this.settled = new HashSet(this.vertices);
    for (int i = 0; i < this.vertices; i++) {
      this.adj.add(new LinkedList<>());
      this.parent[i] = -1;
      this.dist[i] = Integer.MAX_VALUE;
    }
  }
  public static void main(String[] args) {
    int vertices = 9;
    MinimumWeightCycleInUndirectedGraph min = new MinimumWeightCycleInUndirectedGraph(vertices);
    min.initGraph();
    min.makeEdgeArray();
    System.out.print(min.printMinimumWeightCycle());
  }


//logic is fine but need to fix the graph.
  private int printMinimumWeightCycle() {
    int minCycle = Integer.MAX_VALUE;

    for (int i = 0; i < this.edges.size(); i++) {
      GraphEdge edge = edges.get(i);

      removeEdge(edge);

      int path = shortestPath(edge.src, edge.dest);

      minCycle = Math.min(minCycle, path + edge.cost);

      addEdge(edge);
    }

    return minCycle;
  }

  private int shortestPath(int src, int dest) {
    Arrays.fill(this.parent, -1);
    Arrays.fill(this.dist, Integer.MAX_VALUE);
    this.settled.clear();
    this.dist[src] = 0;
    PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> {
      if (a.cost < b.cost) {
        return -1;
      } else if (a.cost > b.cost) {
        return 1;
      } else {
        return 0;
      }
    });

    pq.add(new GraphNode(src, dist[src]));

    while(settled.size() != this.vertices) {
      GraphNode temp = pq.poll();
      updateAdjacentVertices(pq, temp);
      this.settled.add(temp.node);
    }

    return this.dist[dest];
  }

  private void updateAdjacentVertices(PriorityQueue<GraphNode> pq, GraphNode src) {
    Iterator<GraphNode> it = this.adj.get(src.node).iterator();
    while (it.hasNext()) {
      GraphNode next = it.next();
      if (!this.settled.contains(next)) {
        int edge = next.cost;
        int settledCost = dist[src.node];
        if (dist[next.node] > edge + settledCost) {
          dist[next.node] = edge + settledCost;
          parent[next.node] = src.node;
          pq.add(new GraphNode(next.node, dist[next.node]));
        }
      }
    }
  }

  private void addEdge(GraphEdge edge) {
    this.adj.get(edge.src).add(new GraphNode(edge.dest, edge.cost));
    this.adj.get(edge.dest).add(new GraphNode(edge.src, edge.cost));
  }

  private void removeEdge(GraphEdge edge) {
    this.adj.get(edge.src).remove(new GraphNode(edge.dest, edge.cost));
    this.adj.get(edge.dest).remove(new GraphNode(edge.src, edge.cost));
  }

  private void makeEdgeArray() {
    for (int i = 0; i < this.vertices; i++) {
      Iterator<GraphNode> it = this.adj.get(i).iterator();
      while(it.hasNext()) {
        GraphNode next = it.next();
        GraphEdge edge = new GraphEdge(i, next.node, next.cost);
        this.edges.add(edge);
      }
    }
  }

  //refactor to make it undirected graph
  private void initGraph() {
    this.adj.get(0).add(new GraphNode(1, 4));
    this.adj.get(0).add(new GraphNode(7, 8));
    this.adj.get(1).add(new GraphNode(2, 8));
    this.adj.get(1).add(new GraphNode(7, 11));
    this.adj.get(2).add(new GraphNode(3, 7));
    this.adj.get(2).add(new GraphNode(8, 2));
    this.adj.get(2).add(new GraphNode(5, 4));
    this.adj.get(3).add(new GraphNode(4, 9));
    this.adj.get(3).add(new GraphNode(5, 14));
    this.adj.get(4).add(new GraphNode(5, 10));
    this.adj.get(5).add(new GraphNode(6, 2));
    this.adj.get(6).add(new GraphNode(7, 1));
    this.adj.get(6).add(new GraphNode(8, 6));
    this.adj.get(7).add(new GraphNode(8, 7));
  }

}
