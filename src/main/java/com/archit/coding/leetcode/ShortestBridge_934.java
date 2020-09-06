package com.archit.coding.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] a = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
    System.out.println(s.shortestBridge(a));
  }

  static class Solution {
    public int shortestBridge(int[][] a) {
      if (a == null || a.length == 0) {
        return -1;
      }

      int rows = a.length;
      int cols = a[0].length;
      boolean firstIslandFound = false;
      Queue<Node> queue = new LinkedList<>();
      int [] rowNums = {-1, 0, 1, 0};
      int [] colNums = {0, 1, 0, -1};
      int distance = 0; //the shortest bridge length

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (a[i][j] == 1) {
            if (!firstIslandFound) {
              //mark the first island as found by setting cells to 2
              dfs(a, i, j, rowNums, colNums);
              firstIslandFound = true;
            } else {
              //this 1 belongs to the second island
              //Add it to Queue to perform BFS towards the first
              //island
              //add all neighbours
              for (int k = 0; k < rowNums.length; k++) {
                int nextRow = i + rowNums[k];
                int nextCol = j + colNums[k];

                if (isValid(a, nextRow, nextCol)
                    && a[nextRow][nextCol] == 0) {
                  queue.add(new Node(nextRow, nextCol, 1));
                }
              }
            }
          }
        }
      }

      int dist = 0;
      while(!queue.isEmpty()) {
        int size = queue.size();
        int count = 0;

        while (count < size) {
          Node node = queue.poll();
          count++;

          if (a[node.row][node.col] == 1) {
            continue;
          }

          if (a[node.row][node.col] == 2) {
            // return node.dist - 1;
            return dist;
          }

          if(a[node.row][node.col] == 0) {
            //add this cell to the second island
            a[node.row][node.col] = 1;
            //add all valid neighbours
            for (int i = 0; i < rowNums.length; i++) {
              int nextRow = node.row + rowNums[i];
              int nextCol = node.col + colNums[i];

              if (isValid(a, nextRow, nextCol)) {
                queue.add(new Node(nextRow, nextCol, node.dist + 1));
              }
            }

          }
        }
        dist++;
      }

      return -1;
    }

    private void dfs(int[][] a, int row, int col,
                     int[] rowNums, int[] colNums) {
      a[row][col] = 2;

      for (int i = 0; i < rowNums.length; i++) {
        int nextRow = row + rowNums[i];
        int nextCol = col + colNums[i];

        if (isValid(a, nextRow, nextCol) && a[nextRow][nextCol] == 1) {
          dfs(a, nextRow, nextCol, rowNums, colNums);
        }
      }
    }

    private boolean isValid(int[][] a, int row, int col) {
      return row >= 0 && row < a.length
          && col >= 0 && col < a[0].length;
    }
  }



  static class Node {
    int row;
    int col;
    int dist;

    public Node(int row, int col, int dist) {
      this.row = row;
      this.col = col;
      this.dist = dist;
    }
  }

}
