package com.archit.coding.practice.dynamicprogramming;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    String str = "forgeeksskeegfor";
//    geeksskeeg
    System.out.println("Length is: " + longestPalSubstr(str));
  }

  private static String longestPalSubstr(String s) {
    int n = s.length();
    boolean [][] dp = new boolean[n][n];

    // one char is always palindrome
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    //checking for 2 chars
    int start = 0;
    int length = 0;
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i+1)) {
        dp[i][i+1] = true;
        start = i;
        length = 2;
      }
    }

    //checking for lengths greater than 2 to length of string
    for (int l = 3; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
          dp[i][j] = true;
          if (l > length) {
            length = l;
            start = i;
          }
        }
      }
    }

    return s.substring(start, start + length);
  }
}
