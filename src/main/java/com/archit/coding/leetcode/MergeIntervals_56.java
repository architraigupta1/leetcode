package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals_56 {
  public static void main(String[] args) {

  int a[][] = {{1,3},{2,6},{8,10},{15,18}};
  Solution s = new Solution();
  int b[][] = s.merge(a);
  System.out.print(b);

  }
  static class Solution {
    public int[][] merge(int[][] intervals) {
      int n = intervals.length;

      if(n == 0 || n == 1) {
        return intervals;
      }

      List<Pair> pairs = new ArrayList();
      for (int i = 0; i < n; i++) {
        pairs.add(new Pair(intervals[i][0], intervals[i][1]));
      }

      pairs.sort((a, b) -> {
        if(a.s < b.s) {
          return -1;
        } else if (a.s > b.s) {
          return 1;
        } else {
          return 0;
        }
      });

      int [][] sol = new int[n][2];
      int k = 0;
      Pair cur = pairs.get(0);
      for(int i = 1; i < n; i++) {
        Pair next = pairs.get(i);
        if(next.s <= cur.e && cur.s <= next.e) {
          cur.s = cur.s <= next.s ? cur.s : next.s;
          cur.e = cur.e >= next.e ? cur.e : next.e;
        } else {
          sol[k][0] = cur.s;
          sol[k][1] = cur.e;
          k++;
          cur = next;
        }
      }

      sol[k][0] = cur.s;
      sol[k][1] = cur.e;
      int result [][] = new int[k+1][2];
      for (int i = 0; i <= k; i++) {
        result[i][0] = sol[i][0];
        result[i][1] = sol[i][1];
      }

      return result;
    }
  }

  static class Pair {
    int s;
    int e;
    public Pair (int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
}
