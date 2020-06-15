package com.archit.coding.practice.dynamicprogramming;

public class SubsetSum {
  public static void main(String[] args) {
    int set[] = { 3, 34, 4, 12, 5, 2 };
    int sum = 9;
    int n = set.length;
    if (isSubsetSum(set, n, sum))
      System.out.println("Found a subset with given sum");
    else
      System.out.println("No subset with given sum");
  }

  private static boolean isSubsetSum(int[] set, int n, int sum) {
    boolean[][] dp = new boolean[n][sum + 1];

    //case when sum is 0, it can be formed with an empty set
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    //case when there is only one element in the set
    for (int j = 1; j <= sum; j++) {
      if (set[0] == j) {
        dp[0][j] = true;
      } else {
        dp[0][j] = false;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (j < set[i]) {
          dp[i][j] = dp[i-1][j];
        } else {
          dp[i][j] = dp[i-1][j - set[i]] || dp[i-1][j];
        }
      }
    }

    return dp[n-1][sum];
  }
}
