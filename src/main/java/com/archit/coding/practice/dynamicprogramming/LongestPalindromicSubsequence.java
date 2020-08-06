package com.archit.coding.practice.dynamicprogramming;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    String s = "agbdba";
    int n = s.length();
    int[][] dp = new int[n][n];

    //if the string is one one length,
    // then the max length possible is 1
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for (int l = 2; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (l == 2 && s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2;
        } else if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2 + dp[i+1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
        }
      }
    }

    System.out.print(dp[0][n-1]);
  }
}
