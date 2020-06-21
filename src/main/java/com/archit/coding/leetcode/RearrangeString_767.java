package com.archit.coding.leetcode;

import java.util.PriorityQueue;

public class RearrangeString_767 {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.reorganizeString("aaab");
  }

  static class Solution {
    public String reorganizeString(String s) {
      if (s.isEmpty()) {
        return s;
      }
      int [] count = new int [26];
      PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->
          b.freq < a.freq ? -1 : b.freq == a.freq ? 0 : 1
      );

      for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
      }

      for(int i = 0; i < 26; i++) {
        if (count[i] != 0) {
          pq.add(new Node((char)('a' + i), count[i]));
        }
      }

      StringBuilder sb = new StringBuilder();

      Node prev = null;
      while (!pq.isEmpty()) {
        Node cur = pq.poll();
        sb.append(cur.ch);
        cur.freq--;
        if (prev != null && prev.freq != 0) {
          pq.add(prev);
        }
        prev = cur;

      }
      String r = sb.toString();
      return s.length() == r.length() ? r : "";


    }
  }

  static class Node {
    char ch;
    int freq;

    public Node(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }
  }
}
