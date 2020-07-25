package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistApart_358 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.rearrangeString("aaabc", 3));
  }

  static class Solution {
    public String rearrangeString(String s, int k) {
      if (s == null || s.isEmpty()) {
        return "";
      }

      if (k < 2) {
        return s;
      }

      int n = s.length();

      //prepare freq map
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int count = map.getOrDefault(s.charAt(i), 0);
        map.put(s.charAt(i), count + 1);
      }

      //add all keys to pq
      PriorityQueue<Node> pq = new PriorityQueue<>(
          (a,b) -> b.freq < a.freq ? -1 : b.freq == a.freq ? 0 : 1);
      for (Character key : map.keySet()) {
        Node node = new Node(key, map.get(key));
        pq.add(node);
      }

      StringBuilder sb = new StringBuilder();
      int i = 0;
      Queue<Node> q = new LinkedList<>();

      //if pq is empty, there is no char that can be added to current pos
      while(i < n && !pq.isEmpty()) {


        //remove the highest freq key from pq
        Node maxNode = pq.poll();
        maxNode.freq--;

        //add the highest freq node to result
        sb.append(maxNode.ch);

        //if freq is greater than 1, only then add to Q
        if (maxNode.freq > 0) {
          maxNode.next = i + k - 1;
          q.add(maxNode);
        }

        if (!q.isEmpty() && i == q.peek().next) {
          Node node = q.poll();
          pq.add(node);
        }

        i++;
      }

      if (sb.length() == n) {
        return sb.toString();
      } else {
        return "";
      }
    }
  }

  static class Node {
    char ch;
    int freq;
    int next;

    public Node(char ch, int f) {
      this.ch = ch;
      this.freq = f;
    }
  }

/*
1. count the freq of each char
2. Create a max heap based on char freq.
3. while (i < n)
    - Extract the max freq char and add it to string
    - Remove max freq char from pq and it to a Q
    - If count == k, then start adding the front element to PQ.

*/
}
