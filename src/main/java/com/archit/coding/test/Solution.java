package com.archit.coding.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  static String[][] wordCountEngine(String document) {
    // your code goes here
    if (document == null || document.isEmpty()) {
      return new String[0][0];
    }

    String[] words = document.split(" "); //words array
    int n = words.length;

    Map<String, Node> map = new HashMap<>();
    int maxFreq = Integer.MIN_VALUE;

    //prepare word -> Node map
    for (int i = 0; i < n ; i++) {
      String word = sanitize(words[i]);
      if (map.containsKey(word)) {
        Node node = map.get(word);
        node.freq++;
        maxFreq = Math.max(maxFreq, node.freq);
        map.put(word, node);
      } else {
        Node node = new Node(word, 1, i);
        map.put(word, node);
      }
    }

    List<Node>[] list = new ArrayList[maxFreq+1];
    for (int i = 0; i < maxFreq + 1; i++) {
      list[i] = new ArrayList<Node>();
    }

    for(String key : map.keySet()) {
      Node node = map.get(key);
      int index = node.freq;
      List<Node> nodes = list[index];
      nodes.add(node);
    }

    String[][] result = new String[map.size()][2];
    int j = 0;
    for (int i = maxFreq; i >= 0; i--) {
      if (!list[i].isEmpty()) {
        List<Node> nodes = list[i];
        Collections.sort(nodes, (a, b) ->
            a.index < b.index ? -1 : a.index == b.index ? 0 : 1);

        for (int k = 0; k < nodes.size(); k++) {
          result[j][0] = nodes.get(k).word;
          result[j][1] = String.valueOf(nodes.get(k).freq);
          j++;
        }
      }
    }

    return result;
  }

  private static String sanitize(String word) {
    int n = word.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (Character.isAlphabetic(word.charAt(i))) {
        sb.append(Character.toLowerCase(word.charAt(i)));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String doc = "Every book is a quotation; and every house is a quotation out of all forests," +
        " and mines, and stone quarries; and every man is a quotation from all his ancestors. ";
    wordCountEngine(doc);
  }



}

class Node
{
  String word;
  int freq;
  int index;

  public Node (String word, int freq, int index) {
    this.word = word;
    this.freq = freq;
    this.index = index;
  }
}


