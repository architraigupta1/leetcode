package com.archit.coding.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler_621 {

  public static void main(String[] args) {
    char[] a = {'A','A','A','B','B','B'};
    int n = 2;
    Solution s = new Solution();
    System.out.print(s.leastInterval(a, n));
  }

  static class Solution {
    public int leastInterval(char[] tasks, int n) {
      if(n == 0) {
        return tasks.length;
      }
      //count the freq of chars
      int [] count = new int [26];
      for (int i = 0; i < tasks.length; i++) {
        count[tasks[i] - 'A']++;
      }
      // make a max heap to always get the max freq char
      PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->
          b.freq < a.freq ? -1 : b.freq == a.freq ? 0 : 1
      );

      for (int i = 0; i < 26; i++) {
        if (count[i] != 0) {
          pq.add(new Node((char)(i + 'A'), count[i]));
        }
      }

      int index = 0;
      Queue<Node> q = new LinkedList();
      //generate indexes for chars based on gaps n
      while(!pq.isEmpty() || !q.isEmpty()) {
        Node node = !pq.isEmpty() ? pq.poll() : new Node('x', 0);
        node.next = index + n + 1;
        node.freq--;
        if (node.freq > 0) {
          q.add(node);
        }
        index++;
        while (!q.isEmpty() && q.peek().next <= index) {
          pq.add(q.poll());
        }
      }
      //return the max index
      return index;
    }
  }

  static class Node {
    char c;
    int freq;
    int next;

    public Node(char c, int freq) {
      this.c = c;
      this.freq = freq;
    }
  }
}
