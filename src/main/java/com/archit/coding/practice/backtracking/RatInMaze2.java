package com.archit.coding.practice.backtracking;

public class RatInMaze2 {
  public static void main(String[] args) {
    int[][] maze = {
        {1, 1, 1, 1},
        {1, 1, 0, 1},
        {0, 0, 0, 1},
        {1, 1, 1, 1}};

    int rows = maze.length;
    int cols = maze[0].length;

    int[][] path = new int[rows][cols]; //o(rows * cols)
    path[0][0] = 1;

    if (solve(maze, path, 0, 0)) {
      printPath(path); //time: o(rows * cols)
    } else {
      System.out.println("No path possible");
    }
  }

  private static void printPath(int[][] path) {
    for (int i = 0; i < path.length; i++) {
      for (int j = 0; j < path[0].length; j++) {
        System.out.print(path[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static boolean solve(int[][] maze, int [][] path, int row, int col) {
    if (row == maze.length - 1 && col == maze[0].length - 1) {
      return true;
    }

    int [] rowNums = {1, 0};
    int [] colNums = {0, 1};

    for (int i = 0; i < 2; i++) {
      int nextRow = row + rowNums[i];
      int nextCol = col + colNums[i];

      if (isValid(maze, nextRow, nextCol)) {
        path[nextRow][nextCol] = 1;
        boolean result = solve(maze, path, nextRow, nextCol);
        if (result) {
          return true;
        }
        path[nextRow][nextCol] = 0;
      }
    }
    return false;
  }

  //time: o(1)
  private static boolean isValid(int[][] maze, int row, int col) {
    return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 1;
  }
}
