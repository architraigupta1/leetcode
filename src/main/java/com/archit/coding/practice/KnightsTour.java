package com.archit.coding.practice;

public class KnightsTour {
  public static void main(String[] args) {
    int boardSize = 8;
    int board [][] = new int[boardSize][boardSize];
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        board[i][j] = -1;
      }
    }
    KnightsTour tour = new KnightsTour();
    int move = 0;
    board[0][0] = move;
    if (tour.perfromTour(board, 0, 0, move + 1, boardSize)) {
      tour.printSol(board);
    } else {
      System.out.print("Solution does not exists");
    }
  }



  private boolean perfromTour(int[][] board, int row, int col, int move, int boardSize) {
    if (move == boardSize*boardSize) {
      return true;
    }
    int[] rowNums = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] colNums = {-2, -1, 1, 2, 2, 1, -1, -2};

    for (int i = 0; i < 8; i++) {
      int nextRow = row + rowNums[i];
      int nextCol = col + colNums[i];
      if (isSafe(nextRow, nextCol, boardSize) && board[nextRow][nextCol] == -1) {
        board[nextRow][nextCol] = move;
        if(perfromTour(board, nextRow, nextCol, move + 1, boardSize)) {
          return true;
        } else {
          board[nextRow][nextCol] = -1;
        }
      }
    }
    return false;
  }

  private boolean isSafe(int nextRow, int nextCol, int boardSize) {
    return nextRow >= 0 && nextRow < boardSize && nextCol >= 0 && nextCol < boardSize;
  }

  private void printSol(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
