package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CriticalConnectionsInNetwork_1192 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int n = 6;
    Integer[][] edges = {{0,1},{1,2},{2,0},{1,3}, {3,4}, {4,5}, {5,3}};
    List<List<Integer>> cons = new ArrayList<>();
    for(Integer[] edge : edges) {
      List<Integer> l = Arrays.asList(edge);
      cons.add(l);
    }

    List<List<Integer>> result = s.criticalConnections(n, cons);
    System.out.println();
  }

  static class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

      List<LinkedList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adj.add(new LinkedList<Integer>());
      }

      for (List<Integer> connection : connections) {
        int src = connection.get(0);
        int dest = connection.get(1);
        adj.get(src).add(dest);
        adj.get(dest).add(src);
      }

      List<List<Integer>> result = new ArrayList<>();
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < adj.size(); i++) {
        int src = i;
        LinkedList<Integer> edges = adj.get(src);
        for (int j = 0; j < edges.size(); j++) {
          int dest = edges.removeFirst();
          if (map.containsKey(dest) && map.get(dest) == i) {
            edges.addLast(dest);
            continue;
          }
          map.put(i, dest);
          int index = adj.get(dest).indexOf(src);
          adj.get(dest).remove(index);

          if(critical(adj)) {
            List<Integer> sol = new ArrayList<>();
            sol.add(i);
            sol.add(dest);
            result.add(sol);
          }
          edges.addLast(dest);
//          adj.get(dest).add(src);
        }
      }

      return result;
    }

    private boolean critical(List<LinkedList<Integer>> adj) {
      int vertices = adj.size();
      boolean[] visited = new boolean[vertices];
      dfs(0, adj, visited);

      for (int i = 0; i < vertices; i++) {
        if (!visited[i]) {
          return true;
        }
      }
      return false;
    }

    private void dfs(int src, List<LinkedList<Integer>> adj, boolean[] visited) {
      visited[src] = true;
      LinkedList<Integer> edges = adj.get(src);
      for (int i = 0; i < edges.size(); i++) {
        if (!visited[edges.get(i)]) {
          dfs(edges.get(i), adj, visited);
        }
      }
    }
  }

}
