package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords_692 {
  public static void main(String[] args) {

  }

  static class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      Map<String, Node> map = new HashMap<>();
      for (String word : words) {
        Node node = map.getOrDefault(word, new Node(word));
        node.freq++;
        map.put(word, node);
      }

      PriorityQueue<Node> pq = new PriorityQueue<>(map.size(), (word1, word2) -> {
        if (word1.freq != word2.freq) {
          return word2.freq < word1.freq ? -1 : 1;
        }

        return word1.word.compareTo(word2.word);
      });

      for (String key : map.keySet()) {
        Node node = map.get(key);
        pq.add(node);
      }

      int count = 0;
      List<String> result = new ArrayList<>();
      while(count < k) {
        result.add(pq.poll().word);
        count++;
      }

      return result;
    }
  }

  static class Node {
    String word;
    int freq;

    public Node(String word) {
      this.word = word;
    }
  }
/*
- get the freq of each word
- prepare a max heap
-
*/
}
