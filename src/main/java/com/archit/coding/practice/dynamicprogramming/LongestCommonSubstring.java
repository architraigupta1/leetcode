package com.archit.coding.practice.dynamicprogramming;

public class LongestCommonSubstring {
  public static void main(String[] args) {
    String X = "OldSite:GeeksforGeeks.org";
    String Y = "NewSite:GeeksQuiz.com";

    System.out.println("Length of Longest Common Substring is "
        + LCSubStr(X.toCharArray(), Y.toCharArray()));
  }

  private static int LCSubStr(char[] a, char[] b) {
    int l1 = a.length;
    int l2 = b.length;
    int[][] dp = new int[l1 + 1][l2 + 1];

    //when second string is empty, max length is 0
    for (int i = 0; i < l1; i++) {
      dp[i][0] = 0;
    }

    //when first string is empty, max length is 0
    for (int j = 0; j < l2; j++) {
      dp[0][j] = 0;
    }

    int result = 0;
    for (int i = 1; i <= l1; i++) {
      for (int j = 1; j <= l2; j++) {
        if (a[i-1] == b[j-1]) {
          dp[i][j] = 1 + dp[i-1][j-1];
          result = Math.max(result, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return result;
  }
}
