package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Skyline_218 {
  public static void main(String[] args) {
    int[][] buildings = {{0,2,3},{2,5,3}};
    Solution s = new Solution();
    System.out.println(s.getSkyline(buildings).toString());


  }
  static class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
      List<List<Integer>> sky = new ArrayList<>();
      if (buildings == null || buildings.length == 0) {
        return sky;
      }

      int n = buildings.length;
      List<Point> points = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        Point s = new Point(buildings[i][0], buildings[i][2], true);
        Point e = new Point(buildings[i][1], buildings[i][2], false);
        points.add(s);
        points.add(e);
      }

      Collections.sort(points, (a, b) -> {



        if (a.x != b. x) {
          return a.x - b.x;
        }
        else {
          if (a.start && b.start) {
            return b.y - a.y;
          } else if (!a.start && !b.start) {
            return a.y - b.y;
          } else if (!a.start) {
            return 1;
          } else {
            return -1;
          }
        }
      });

      TreeMap<Integer, Integer> pq = new TreeMap<>();
      pq.put(0, 1);
      int prevMax = 0;
      for (int i = 0; i < points.size(); i++) {
        Point p = points.get(i);
        int count = pq.getOrDefault(p.y, 0);
        if (p.start) {
          pq.put(p.y, count + 1);
        } else {
          if (count == 1) {
            pq.remove(p.y);
          } else {
            pq.put(p.y, count - 1);
          }
        }

        int curMax = pq.lastKey();

        if (prevMax != curMax) {
          List<Integer> cp = new ArrayList<>();
          cp.add(p.x);
          cp.add(curMax);
          sky.add(cp);
          prevMax = curMax;
        }

      }

      return sky;

    }
  }

  static class Point {
    int x;
    int y;
    boolean start;

    public Point(int x, int y, boolean start) {
      this.x = x;
      this.y = y;
      this.start = start;
    }
  }
}
