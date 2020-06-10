package com.archit.coding.utils;

import java.util.LinkedList;

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
}
