package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MergeIntervals_56 {
  public static void main(String[] args) {

  int a[][] = {{374,383},{314,319},{441,446},{268,275},{466,470},{232,238},{284,292},{383,390},{356,361},{365,368},{327,330},{122,131},{149,153},{258,265},{343,350},{472,481},{17,25},{85,85},{16,21},{399,401},{79,81},{360,365},{250,253},{34,42},{150,159},{53,62},{14,20},{29,32},{310,319},{73,79},{347,354},{427,433},{36,40},{378,380},{70,78},{34,43},{410,414},{217,217},{489,490},{470,479},{3,7},{468,477},{52,61},{385,387},{341,349},{220,228},{355,355},{256,257},{364,368},{295,299},{412,421},{436,440},{75,80},{186,190},{108,115},{55,56},{181,185},{333,336},{225,233},{447,453},{176,176},{106,109},{372,374},{127,133},{349,351},{23,26},{104,105},{288,297},{168,174},{96,102},{483,484},{240,246},{175,178},{101,102},{143,144},{319,320},{273,279},{54,61},{140,141},{85,94},{104,112},{455,455},{271,274},{239,240},{421,426},{420,427},{487,487},{273,277},{85,92},{267,267},{480,489},{251,256},{365,370},{102,107},{339,346},{495,500},{148,148},{355,356},{45,49},{63,71},{282,285},{75,76},{495,504},{487,489},{428,435}};
    Arrays.sort(a, (x, y) -> {
      if (x[0] < y[0]) {
        return -1;
      } else if (x[1] > y[1]) {
        return 1;
      } else {
        return 0;
      }
    });

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

      Arrays.sort(intervals, (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1);

      int[] cur = intervals[0];
      List<int[]> result = new ArrayList();
      for(int i = 1; i < n; i++) {
        int[] next = intervals[i];
        if(next[0] <= cur[1] && cur[0] <= next[1]) {
          cur[0] = Math.min(cur[0], next[0]);
          cur[1] = Math.max(cur[1], next[1]);
        } else {
          result.add(cur);
          cur = next;
        }
      }

      result.add(cur);

      return result.toArray(new int[result.size()][2]);
    }
  }

  class Pair {
    int s;
    int e;
    public Pair (int s, int e) {
      this.s = s;
      this.e = e;
    }
  }

}
