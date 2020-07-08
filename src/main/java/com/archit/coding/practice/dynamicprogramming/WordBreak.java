package com.archit.coding.practice.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

public class WordBreak {
  public static void main(String[] args) {
    String s = "catanddog";
    HashSet<String> dictionary = new HashSet<>(Arrays.asList(
        "cat", "cats", "sand", "dog", "and"));

    System.out.println(canBreakWords(s, dictionary));
  }

  private static boolean canBreakWords(String s, HashSet<String> dictionary) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      if (dictionary.contains(s.substring(i,i+1))) {
        dp[i][i] = true;
      }
    }

    for (int l = 2; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (dictionary.contains(s.substring(i, j + 1))) {
          dp[i][j] = true;
        } else {
          for (int k = i; k <= j; k++) {
            if (dp[i][k] && dp[k+1][j]) {
              dp[i][j] = true;
              break;
            }
          }
        }
      }
    }

    return dp[0][n-1];
  }
}
