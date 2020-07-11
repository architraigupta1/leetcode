package com.archit.coding.practice.graph;

import com.archit.coding.utils.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
  public static void main(String[] args) {
    String[] words = {"z", "z"};
    int n = words.length;
    int k = 4;
    Graph graph = new Graph(k);
    for (int i = 0; i < words.length - 1; i++) {
      int j = i+1;
      String word1 = words[i];
      String word2 = words[j];
      int len1 = word1.length();
      int len2 = word2.length();
      int index = 0;
      char src;
      char dest;
      while(index < len1 && index < len2 && word1.charAt(index) == word2.charAt(index)) {
        index++;
      }
      if (index == len1 || index == len2) {
        continue;
      } else {
        src = word1.charAt(index);
        dest = word2.charAt(index);
        graph.addDirectedEdge(src - 'a', dest - 'a');
      }
    }
    findOrder(graph);
  }

  private static void findOrder(Graph graph) {
    int[] indegree = new int[graph.vertices];
    for (int i = 0; i < graph.vertices; i++) {
      Iterator<Integer> it = graph.adj[i].iterator();
      while(it.hasNext()) {
        indegree[it.next()]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < graph.vertices; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int node = q.poll();
      System.out.print((char) (97 + node));

      Iterator<Integer> it = graph.adj[node].iterator();
      while(it.hasNext()) {
        Integer next = it.next();
        indegree[next]--;
        if (indegree[next] == 0) {
          q.add(next);
        }
      }
    }
  }

}
