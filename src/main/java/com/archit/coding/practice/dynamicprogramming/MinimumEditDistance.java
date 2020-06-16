package com.archit.coding.practice.dynamicprogramming;

public class MinimumEditDistance {
  public static void main(String[] args) {
    String str1 = "sunday";
    String str2 = "saturday";

    System.out.println(editDist(str1, str2, str1.length(), str2.length()));
  }

  private static int editDist(String a, String b, int m, int n) {
    int [][] dp = new int[m+1][n+1];

    //case when first string is empty, we will have to perform n inserts
    for (int i = 0; i <=m; i++) {
      dp[i][0] = i;
    }

    //case when second string is empty, we will have to perform m inserts
    for (int j = 0; j <=n; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (a.charAt(i-1) == b.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
      }
    }
    return dp[m][n];
  }
}
