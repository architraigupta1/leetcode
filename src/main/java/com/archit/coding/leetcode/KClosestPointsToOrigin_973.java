package com.archit.coding.leetcode;

import com.archit.coding.utils.ArrayUtil;

import java.util.PriorityQueue;
import java.util.Stack;

public class KClosestPointsToOrigin_973 {
  public static void main(String[] args) {
    int[][] points = {{3,3},{5,-1},{-2,4}};
      Solution s = new Solution();
      int[][] b = s.kClosest(points, 2);
    ArrayUtil.print2DArray(b);
  }

  static class Solution {
    public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<Node> pq = new PriorityQueue<>(k, (a, b) ->

        b.total < a.total ? -1 : b.total == a.total ? 0 : 1
      );

      int count = 0;
      for (int i = 0; i < points.length; i++) {
        int dist = points[i][0] * points[i][0] + points[i][1]*points[i][1];
        if (count < k) {
          pq.add(new Node(dist, i));
          count++;
        } else if (pq.peek().total > dist) {
          pq.poll();
          pq.add(new Node(dist, i));
        }
      }

      int [][] sol = new int[k][2];
      int i = 0;
      while(!pq.isEmpty()) {
        Node temp = pq.poll();
        sol[i][0] = points[temp.i][0];
        sol[i][1] = points[temp.i][1];
        i++;
      }

      return sol;
    }
  }

  static class Node {
    int total;
    int i;

    public Node(int total, int i) {
      this.total = total;
      this.i = i;
    }
  }
}
