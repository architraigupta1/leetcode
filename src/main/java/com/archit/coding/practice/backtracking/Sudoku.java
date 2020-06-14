package com.archit.coding.practice.backtracking;

public class Sudoku {
  public static void main(String[] args) {
    int[][] grid = {
        {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    int rows = grid.length;
    int cols = grid[0].length;
    Sudoku s = new Sudoku();
    if (s.solve(grid, rows, cols)) {
      s.print(grid, rows, cols);
    } else {
      System.out.println("Cannot be solved");
    }

  }

  private boolean solve(int[][] grid, int rows, int cols) {
    int row = -1;
    int col = -1;
    boolean solved = true;
    for (int i = 0 ; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 0) {
          row = i;
          col = j;
          solved = false;
          break;
        }
      }
      if (!solved) {
        break;
      }
    }

    if (solved) {
      return solved;
    }

    for (int i = 1; i <= 9 ; i++) {
      if (isSafe(grid, row, col, i)) {
        grid[row][col] = i;
        if (solve(grid, rows, cols)) {
          return true;
        } else {
          grid[row][col] = 0;
        }
      }
    }
    return false;
  }

  private boolean isSafe(int[][] grid, int row, int col, int value) {

    //check if column has this value
    for (int i = 0; i < grid.length; i++) {
      if (grid[i][col] == value) {
        return false;
      }
    }

    //check if row has this value
    for (int j = 0; j < grid[0].length; j++) {
      if (grid[row][j] == value) {
        return false;
      }
    }

    //check if block has this value
    int rowStart = row - row % 3;
    int colStart = col - col % 3;

    for (int i = rowStart; i < rowStart + 3; i++) {
      for (int j = colStart; j < colStart + 3; j++) {
        if (grid[i][j] == value) {
          return false;
        }
      }
    }
    return true;
  }

  private void print(int[][] grid, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
}
