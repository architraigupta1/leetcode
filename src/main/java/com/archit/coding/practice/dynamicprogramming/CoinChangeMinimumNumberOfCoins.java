package com.archit.coding.practice.dynamicprogramming;

import com.archit.coding.utils.ArrayUtil;

import java.util.Arrays;

public class CoinChangeMinimumNumberOfCoins {
  public static void main(String[] args) {
    int coins[] = {9, 6, 5, 1};
//    Arrays.sort(coins);
    int m = coins.length;
    int change = 11;
    System.out.println ( "Minimum coins required is "
        + minCoins(coins, m, change));
  }

  private static int minCoins(int[] coins, int n, int change) {
    int dp[][] = new int[n][change + 1];

    //when we have to make 0 change, then minimum coins is 0.
    for (int i = 0; i < n; i++) {
      dp[i][0] = 0;
    }

    //when there is only one coin to make the change, then the min #coins is change/coin
    //else sum cannot be formed.
    for (int j = 1; j <= change; j++) {
      if (j % coins[0] == 0){
        dp[0][j] = j / coins[0];
      } else {
        dp[0][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= change; j++) {
        if (j < coins[i]) {
          dp[i][j] = dp[i-1][j];
        } else {
          int minCoins = dp[i][j - coins[i]];
          if (minCoins == Integer.MAX_VALUE) {
            dp[i][j] = dp[i-1][j];
          } else {
            dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i]]);
          }

        }
      }
    }
    return dp[n-1][change];
  }
}
