package com.archit.coding.practice.graph;

public class Coins {
  public static void main(String[] args) {
    int[] coins = {1,2, 3, 5};
    int sum = 4;
    System.out.println(coinWays(coins, sum));
  }



  private static int coinWays(int[] coins, int sum) {
    if (sum == 0 || coins.length == 0) {
      return 0;
    }

    int n = coins.length;
    int [][] dp = new int[n][sum + 1]; //all elements are 0 by default

    //case when we have to make sum = 0, the first col should be 0

    //case when we have only 1 coin
    for (int j = 1; j <= sum; j++) {
      if (j % coins[0] == 0) {
        dp[0][j] = 1;
      }
    }

    //case when we have more coins
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (j < coins[i]) {
          dp[i][j] = dp[i-1][j]; // current coin will not have any role
        } else {
          dp[i][j] = dp[i][j - coins[i]] + dp[i-1][j];
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= sum; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }

    return dp[n-1][sum];

  }
}
