package com.archit.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
  //length : L, words: n
  //Time: o(n^2*L) + o(n + E) + o(n*L) ~ o(L*n^2)
  static int shortestWordEditPath(String source, String target, String[] words) {
    // your code goes here
    //adj list
    int srcLen = source.length();
    int targetLen = target.length();
    if (srcLen != targetLen) {
      return -1;
    }
    Map<String, Set<String>> adj = new HashMap<>(); //o(n^2)
    int n = words.length;

    //add edges from src to all the dict words
    populateGraph(adj, source, words);

    //add edges bw words in dict
    //o(n^2*L)
    for (int i = 0; i < n; i++) {
      String src = words[i];
      for (int j = i+1; j < n; j++) {
        String dest = words[j];
        if (isReachable(src, dest)) {
          addEdge(adj, src, dest);
        }
      }
    }

    //bfs
    Queue<String> q = new LinkedList<>(); //o(n)
    int level = 0;
    Set<String> visited = new HashSet<>(); //o(n)

    q.add(source);
    visited.add(source);

    //o(n+E)
    while(!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        String node = q.poll();

        Set<String> neis = adj.get(node);
        //o(E)
        for (String nei : neis) {
          if (!visited.contains(nei)) {
            if (nei.equals(target)) {
              return level + 1;
            }

            visited.add(nei);
            q.add(nei);
          }
        }
      }

      level++;
    }

    return -1;

  }

  //o(1)
  private static void addEdge(Map<String, Set<String>> adj, String src, String dest) {
    Set<String> edges1 = adj.getOrDefault(src, new HashSet<>());
    edges1.add(dest);
    adj.put(src, edges1);

    Set<String> edges2 = adj.getOrDefault(dest, new HashSet<>());
    edges2.add(src);
    adj.put(dest, edges2);
  }

  private static void populateGraph(Map<String, Set<String>> adj,
                                    String src, String[] words) {
    int n = words.length;
    //o(nL)
    for (int i = 0; i < n; i++) {
      String dest = words[i];
      if (isReachable(src, dest)) {
        addEdge(adj, src, dest);
      }
    }
  }

  //o(L)
  private static boolean isReachable(String src, String dest) {
    int len = src.length();
    boolean flag = false;
    int i = 0;
    while(i < len) {
      if (src.charAt(i) != dest.charAt(i)) {
        if (flag) {
          break;
        } else {
          flag = true;
        }
      }
      i++;
    }

    return i == len;
  }


  public static void main(String[] args) {
    String[] words = {"but","put","big","pot","pog","pig","dog","lot"};
    System.out.println(shortestWordEditPath("bit", "pog", words));
  }
}

/*
bit -> but -> put -? pot->pog -> dog
all words ahaver same len
*/

