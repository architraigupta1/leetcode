package com.archit.coding.practice.dynamicprogramming;

public class LongestCommonSubsequence {
  public static void main(String[] args) {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";

    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;

    System.out.println("Length of LCS is" + " " +
        lcs.lcs( X, Y, m, n ) );
  }

  private int lcs(char[] x, char[] y, int m, int n) {
    int dp[][] = new int[m+1][n+1];

    //case when second string is empty
    for (int i = 0; i <= m; i++) {
      dp[i][0] = 0;
    }

    //case when first string is empty
    for (int j = 0; j <= n; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i <=m; i++) {
      for (int j = 1; j <=n ;j++) {
        if (x[i-1] == y[j-1]) {
          dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
        }
      }
    }

    return dp[m][n];
  }
}
