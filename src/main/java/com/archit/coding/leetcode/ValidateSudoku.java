package com.archit.coding.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidateSudoku {
  public static void main(String[] args) {

    String[][] board = {
      {"5","3",".",".","7",".",".",".","."},
      {"6",".",".","1","9","5",".",".","."},
      {".","9","8",".",".",".",".","6","."},
      {"8",".",".",".","6",".",".",".","3"},
      {"4",".",".","8",".","3",".",".","1"},
      {"7",".",".",".","2",".",".",".","6"},
      {".","6",".",".",".",".","2","8","."},
      {".",".",".","4","1","9",".",".","5"},
      {".",".",".",".","8",".",".","7","9"}
    };

    int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};

    int rows = a.length;
    int cols = a[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
      }
    }


    Solution s = new Solution();
    System.out.println(s.isValidSudoku(board));
  }

  static class Solution {
    public boolean isValidSudoku(String[][] board) {
      if (board == null || board.length != 9 || board[0].length != 9) {
        return false;
      }

      int rows = board.length;
      int cols = board[0].length;

      //check all rows
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < cols; j++) {
        set.clear();
        for (int i = 0; i < rows; i++) {
          if (board[i][j].charAt(0) == '.') {
            continue;
          }

          if (set.contains(board[i][j].charAt(0))) {
            return false;
          }
          set.add(board[i][j].charAt(0));
        }
      }

      //check all cols
      for (int i = 0; i < rows; i++) {
        set.clear();
        for (int j = 0; j < cols; j++) {
          if (board[i][j].charAt(0) == '.') {
            continue;
          }

          if (set.contains(board[i][j].charAt(0))) {
            return false;
          }
          set.add(board[i][j].charAt(0));
        }
      }

      //check all 3*3 boxes
      for(int i = 0; i < rows; i+=3) {
        for (int j = 0; j < cols; j+=3) {
          set.clear();
          for(int k = i; k < i+3; k++) {
            for (int l = j; l < j + 3; l++) {
              if (board[k][l].charAt(0) == '.') {
                continue;
              }

              if (set.contains(board[k][l].charAt(0))) {
                return false;
              }
              set.add(board[k][l].charAt(0));
            }
          }
        }
      }

      return true;
    }
  }
}
