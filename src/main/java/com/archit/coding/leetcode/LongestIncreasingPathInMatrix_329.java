package com.archit.coding.leetcode;

public class LongestIncreasingPathInMatrix_329 {
  public static void main(String[] args) {
    int[][] matrix = {{1,0,4},{2,1,8},{3,4,1}};
    Solution s = new Solution();
    System.out.println(s.longestIncreasingPath(matrix));
  }

  static class Solution {

    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
        return 0;
      }

      int rows = matrix.length;
      int cols = matrix[0].length;

      int[][] memo = new int[rows][cols]; //default values 0

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          int path = findPath(matrix, i, j, memo);
          max = Math.max(max, path);
        }
      }

      return max;
    }

    private int findPath(int[][] matrix, int row, int col, int[][] memo) {

      int[] rows = {0, -1, 0, 1};
      int[] cols = {-1, 0, 1, 0};
      int maxPath = 1;
      for (int i = 0; i < rows.length; i++) {
        int nextRow = row + rows[i];
        int nextCol = col + cols[i];
        int path = 1;
        if (isValid(matrix, nextRow, nextCol)
            && matrix[nextRow][nextCol] > matrix[row][col]) {

          if (memo[nextRow][nextCol] == 0) {
            path = 1 + findPath(matrix, nextRow, nextCol, memo);
//            memo[nextRow][nextCol] = path;
          } else {
            path = 1 + memo[nextRow][nextCol];
          }

          maxPath = Math.max(maxPath, path);
        }
      }
      memo[row][col] = maxPath;

      return maxPath;
    }

    private boolean isValid(int[][] matrix, int row, int col) {
      return row >= 0 && row < matrix.length
          && col >= 0 && col < matrix[0].length;
    }
  }

/*

1. scan all matrix starting from the leftmost cell
2. For each cell, recursively check the next 4 valid positions
3. go to next cell
    - if it is greater than the current one.
    - if the memo table does not contain the result.
4. from each position return the max length possible.
5. Update the memo table
6. Update global maxima
7. return global maxima

*/
}
