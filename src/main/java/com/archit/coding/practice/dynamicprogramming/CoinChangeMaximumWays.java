package com.archit.coding.practice.dynamicprogramming;

public class CoinChangeMaximumWays {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 5};
    int change = 4;
    System.out.println(count(arr, change));
  }

  private static int count(int[] a, int change) {
    int n = a.length;
    int [][] dp = new int[n][change + 1];

    //when we have to make 0 change, there is only 1 way to not pick any coin
    for (int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }

    // if we have only one coin, then max possibilities is 1
    for (int j = 1; j <= change; j++) {
      if (j % a[0] == 0) {
        dp[0][j] = 1;
      } else {
        dp[0][j] = 0;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= change; j++) {
        // if the total to make is less than coin's value,
        // then this coin cannot be used to make this total.
        // The number of ways will be equal to the number of ways to
        // make this total without this coin.
        if (j < a[i]) {
          dp[i][j] = dp[i-1][j];
        } else {
          //the number of ways this total can be made without this coin +
          // number of ways the remaining amount can be made if we include this coin.
          dp[i][j] = dp[i-1][j] + dp[i][j - a[i]];
        }
      }
    }

    return dp[n-1][change];
  }
}
