package com.archit.rippling;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDict {
  static Graph graph = new Graph();
  public static void main(String[] args) {
    String [] words = {"hello", "leetcode"};
    String order = getOrder(words);
    if (order == null) {
      System.out.println("noty ps");
    } else {
      //print order
      System.out.println(order);
    }
   }

  private static String getOrder(String[] words) {
    if (words == null || words.length == 0) {
      return null;
    }

    int n = words.length;
    int i = 0;

    //all the words // n*L
    while (i < n - 1) {
      String word1 = words[i];
      String word2 = words[i+1];

      int j = 0;
      while (j < word1.length() && j < word2.length()) {
        char c1 = word1.charAt(j);
        char c2 = word2.charAt(j);
        if (c1 != c2) {
          graph.addEdge(c1, c2);
          break;
        }
        j++;
      }
      i++;
    }

    String order = graph.topologicalSort();
    return order;
  }

  static class Graph {
    List<List<Integer>> adj;

    public Graph() {
      this.adj = new ArrayList<>(26);
      for (int i = 0; i < 26; i++) {
        this.adj.add(new ArrayList<>()); //init the graph st there are no edges
      }
    }

    public void addEdge(char c1, char c2) {
      int index1 = c1 - 'a';
      int index2 = c2 - 'a';
      this.adj.get(index1).add(index2); //add directed edge
    }

    public String topologicalSort() {
      //indegree
      int[] indegree = new int[26];
      //o(V + E) v = 26 E = 26*26
      for (int i = 0; i < 26; i++) {
        List<Integer> edges = this.adj.get(i); //outgoing edges from i
        for (int j = 0; j < edges.size(); j++) {
          indegree[edges.get(j)]++;
        }
      }

      Queue<Node> q = new LinkedList<>();
      //find the node with 0 indegree (first char in the order)
      for (int i = 0; i < 26; i++) {
        if (indegree[i] == 0) {
          Node node = new Node(i);
          q.add(node);
        }
      }

      if (q.size() > 1) {
        return null; //indicates no ordering possible
      }

      StringBuilder sb = new StringBuilder();

      while (!q.isEmpty()) {
        Node node =  q.poll();
        sb.append(node.name + 'a');
        List<Integer> neis = this.adj.get(node.name);
        for (int i = 0; i < neis.size(); i++) {
          indegree[neis.get(i)]--;
          if (indegree[neis.get(i)] == 0) {
            Node nei = new Node(neis.get(i));
            q.add(nei);
          }
        }

        if (q.size() > 1) {
          return null;
        }
      }
      return sb.toString();
    }


  }

  static class Node {
    int name;
    public Node(int name) {
      this.name = name;
    }
  }
}
