package com.archit.coding.practice.graph;

public class Palindrome {

  public static void main(String[] args) {
    String s = "ababbac";
    System.out.println(maxPalindrome(s));
  }

  private static int maxPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int n = s.length();
    //default 0 in java
    int[][] dp = new int[n][n]; // i..j => s.substring(i..j);

    //case when string is empty
    //case with substring length = 1
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for (int l = 2; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2;
        } else {
          dp[i][j] = 1;
        }
      }
    }

//    String s = "ababbac";
    for (int l = 3; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2 + dp[i+1][j-1];
        } else {
          dp[i][j] = 0;
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, dp[i][j]);
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }

    return max;
  }
}
