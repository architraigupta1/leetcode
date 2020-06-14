package com.archit.coding.practice.backtracking;

// Complexity 2^(n^2)
public class RatInAMaze {
  public static void main(String[] args) {
    int[][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}};

    int rows = maze.length;
    int cols = maze[0].length;

    int[][] path = new int[rows][cols];
    RatInAMaze sol = new RatInAMaze();
    path[0][0] = 1;
    if(sol.solve(maze, 0, 0, rows, cols, path)) {
      sol.print(path);
    } else {
      System.out.print("No solution");
    }

  }

  private void print(int[][] path) {
    for (int i = 0; i < path.length; i++) {
      for (int j = 0; j < path[0].length; j++) {
        System.out.print(path[i][j] + " ");
      }
      System.out.println();
    }
  }

  private boolean solve(int[][] maze, int row, int col, int rows, int cols, int[][] path) {
    int [] rowNums = {1, 0};
    int [] colNums = {0, 1};

    if (row == rows-1 && col == cols-1) {
      return true;
    }

    for (int i = 0; i < 2; i++) {
      int nextRow = row + rowNums[i];
      int nextCol = col + colNums[i];
      if (isSafe(nextRow, nextCol, rows, cols) && maze[nextRow][nextCol] == 1) {
        path[nextRow][nextCol] = 1;
        if(solve(maze, nextRow, nextCol, rows, cols, path)) {
          return true;
        } else {
          path[nextRow][nextCol] = 0;
        }
      }
    }
    return false;
  }

  private boolean isSafe(int nextRow, int nextCol, int rows, int cols) {
    return nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols;
  }
}
