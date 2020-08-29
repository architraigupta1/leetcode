package com.archit.coding.leetcode;

public class WordSearch {
  public static void main(String[] args) {
    Solution s = new Solution();
    char[][] board = {{ 'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = "z";
    System.out.println(s.exist(board, word));
  }

  static class Solution {
    public boolean exist(char[][] board, String word) {
      if (board == null || board.length == 0 || word == null || word.length() == 0) {
        return false;
      }

      int rows = board.length;
      int cols = board[0].length;

      boolean visited[][] = new boolean[rows][cols];
      int[] rowNums = {0, -1, 0, 1};
      int[] colNums = {-1, 0, 1, 0};
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (Character.toLowerCase(board[i][j]) == Character.toLowerCase(word.charAt(0))) {
            visited[i][j] = true;
            if(checkWord(board, i, j, visited, 1, word, rowNums, colNums)) {
              return true;
            }
            visited[i][j] = false;
          }
        }
      }

      return false;
    }

    private boolean checkWord(char[][] board, int row, int col,
                              boolean[][] visited, int index, String word,
                              int[] rowNums, int[] colNums) {
      if (index == word.length()) {
        return true;
      }

      for (int i = 0; i < 4; i++) {
        int nextRow = row + rowNums[i];
        int nextCol = col + colNums[i];

        if(isValid(board, nextRow, nextCol, word, index)
            && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          if(checkWord(board, nextRow, nextCol, visited, index + 1, word, rowNums, colNums)) {
            return true;
          }
          visited[nextRow][nextCol] = false;
        }
      }

      return false;
    }

    private boolean isValid(char[][] board, int row, int col, String word, int index) {
      return row >= 0 && row < board.length && col >= 0 && col < board[0].length
          && Character.toLowerCase(board[row][col])
          == Character.toLowerCase(word.charAt(index));
    }
  }
}
