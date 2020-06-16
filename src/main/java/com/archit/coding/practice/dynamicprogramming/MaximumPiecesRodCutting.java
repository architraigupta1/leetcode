package com.archit.coding.practice.dynamicprogramming;

public class MaximumPiecesRodCutting {
  public static void main(String[] args) {
    int l = 11, p = 2, q = 3, r = 5;
    System.out.println(findMaximum(l, p, q, r));
  }

  private static int findMaximum(int length, int p, int q, int r) {
    int a[] = {p, q, r};
    int n = a.length;
    int dp[][] = new int[3][length + 1];

    //If the total length of rod is 0, it's not possible to cut it
    for (int i = 0; i < a.length; i++) {
      dp[i][0] = 0;
    }

    //If there is only way to cut the rod, then max pieces = len/piece size
    for (int j = 0; j <= length; j++) {
      if (j % a[0] == 0) {
        dp[0][j] = j / a[0];
      } else {
        dp[0][j] = 0;
      }
    }

    for (int i = 1; i < a.length; i++) {
      for (int j = 1; j <= length; j++) {
        if (j < a[i]) {
          dp[i][j] = dp[i-1][j];
        } else {
            dp[i][j] = Math.max(dp[i-1][j], 1 + dp[i][j - a[i]]);
        }
      }
    }
    return dp[n-1][length];
  }
}
