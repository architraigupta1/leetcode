package com.archit.coding.leetcode;

import java.util.Arrays;

public class CoinsChange_322 {
  public static void main(String[] args) {
    int [] coins = {186,419,83,408};
    int sum = 6249;
    Solution s = new Solution();
    System.out.print(s.coinChange(coins, sum));
  }

  static class Solution {
    public int coinChange(int[] coins, int amount) {
      if (coins == null || coins.length == 0) {
        return -1;
      }

      if (amount == 0) {
        return 0;
      }

      int n = coins.length;
      int dp[][] = new int[n][amount + 1];

      // case when amount is 0
      for (int i = 0; i < n; i++) {
        dp[i][0] = 0;
      }


      //case when there is only one coin
      for (int i = 1; i <= amount; i++) {
        if (i % coins[0] != 0) {
          dp[0][i] = Integer.MAX_VALUE;
        } else {
          dp[0][i] = i / coins[0];
        }
      }

      //case for the remaining coins
      for (int i = 1; i < n; i++) {
        for (int j = 1; j <= amount; j++) {
          if (j < coins[i]) {
            dp[i][j] = dp[i-1][j];
          } else {
            if (dp[i][j - coins[i]] == Integer.MAX_VALUE) {
              dp[i][j] = dp[i-1][j];
            } else {
              dp[i][j] = Math.min(1 + dp[i][j - coins[i]], dp[i-1][j]);
            }
          }
        }
      }

      return dp[n-1][amount] == Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }
  }
}
