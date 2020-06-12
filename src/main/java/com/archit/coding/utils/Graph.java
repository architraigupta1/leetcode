package com.archit.coding.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

  int vertices;
  java.util.LinkedList<Integer>[] adj;

  public Graph(int vertices) {
    this.vertices = vertices;
    this.adj = new LinkedList[this.vertices];
    for (int i = 0; i < this.vertices; i++) {
      this.adj[i] = new LinkedList<>();
    }
  }

  public void addDirectedEdge(int source, int destination) {
    this.adj[source].add(destination);
  }

  public void addUndirectedEdge(int source, int destination) {
    adj[source].add(destination);
    adj[destination].add(source);
  }

  public void addEdge(int source, int destination, boolean directed) {
    if (directed) {
      this.addDirectedEdge(source, destination);
    } else {
      this.addUndirectedEdge(source, destination);
    }
  }

  public void addEdge(int source, int destination) {
    this.addEdge(source, destination, true);
  }

  public void print() {
    for (int i = 0; i < this.vertices; i++) {
      int v = i;
      adj[i].stream().forEach(dest -> System.out.print(v + "->" + dest));
      System.out.println();
    }
  }

  public void dfs(int root, boolean[] visited) {
    visited[root] = true;
    System.out.println(root);

    this.adj[root].stream().forEach(vertex -> {
      if (!visited[vertex]) {
        dfs(vertex, visited);
      }
    });
  }

  public boolean hasCycle() {
    int[] color = new int[this.vertices];
    boolean cycle = false;
    for (int i = 0; i < this.vertices; i++) {
      if (color[i] == 0) {
        cycle = checkCycle(i, color);
        if (cycle) {
          break;
        }
      }
    }
    return cycle;
  }

  private boolean checkCycle(int node, int[] color) {
    if (color[node] == 1) {
      return true;
    }
    color[node] = 1;
    Iterator<Integer> it = this.adj[node].iterator();
    boolean cycle = false;
    while (it.hasNext()) {
      cycle = checkCycle(it.next(), color);
      if (cycle) {
        break;
      }
    }
    color[node] = 2;
    return cycle;
  }

  public ArrayList<Integer> topologicalSort() {
    int[] indegree = new int[this.vertices];
    ArrayList<Integer> topologicalOrder = new ArrayList();

    for (int i = 0; i < this.vertices; i++) {
      Iterator<Integer> it = this.adj[i].iterator();
      while(it.hasNext()) {
        indegree[it.next()]++;
      }
    }

    Queue<Integer> queue = new LinkedList();
    for (int i = 0; i < this.vertices; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while(!queue.isEmpty()) {
      int node = queue.poll();
      topologicalOrder.add(node);
      System.out.print(node + " ");
      Iterator<Integer> it = this.adj[node].iterator();
      while (it.hasNext()) {
        int adjacentNode = it.next();
        indegree[adjacentNode]--;
        if (indegree[adjacentNode] == 0) {
          queue.add(adjacentNode);
        }
      }
    }
    return topologicalOrder;
  }
}