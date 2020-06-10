package com.archit.coding.practice.graph;

public class CountIslands {
  public static void main(String[] args) {
    int m[][] = new int[][] {
        { 1, 1, 0, 0, 0 },
        { 0, 1, 0, 0, 1 },
        { 1, 0, 0, 1, 1 },
        { 0, 0, 0, 0, 0 },
        { 1, 0, 1, 0, 1 }
    };

    CountIslands countIslands = new CountIslands();
    System.out.print(countIslands.count(m));
  }

  private int count(int[][] m) {
    int rows = m.length;
    int cols = m[0].length;

    boolean[][] visited = new boolean[rows][cols];

    int count = 0;
    for (int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        if (!visited[i][j] && m[i][j] == 1) {
          dfs(m, i, j, visited);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(int[][] m, int row, int column, boolean[][] visited) {
    visited[row][column] = true;

    int[] rowNums = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colNums = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int i = 0; i < 8; i++) {
      if(doVisit(m, row + rowNums[i], column + colNums[i], visited )) {
        dfs(m, row + rowNums[i], column + colNums[i], visited);
      }
    }
  }

  private boolean doVisit(int[][] m, int i, int j, boolean[][] visited) {
    if (i >= 0 && i <= m.length - 1 && j >= 0 && j <= m[0].length - 1 && m[i][j] == 1 && !visited[i][j]) {
      return true;
    }
    return false;
  }
}
