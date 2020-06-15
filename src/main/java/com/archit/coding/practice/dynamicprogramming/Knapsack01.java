package com.archit.coding.practice.dynamicprogramming;

//Complexity is O(W * n) where W is the desired weight and n is the size of weight array
public class Knapsack01 {
  public static void main(String[] args) {
    int val[] = new int[] { 60, 100, 120 };
    int wt[] = new int[] { 10, 20, 30 };
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
  }

  private static int knapSack(int weight, int[] wt, int[] val, int n) {
    int[][]dp = new int[n][weight + 1];

    //if required weight is 0, then max value is 0
    for (int i = 0; i < n; i++) {
      dp[i][0] = 0;
    }

    //if only one element is provided then max weight can only be either 0 or the value of that element
    for (int j = 0; j <= weight; j++) {
      if (j < wt[0]) {
        dp[0][j] = 0;
      } else {
        dp[0][j] = val[0];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <=weight; j++) {
        if (j < wt[i]) {
          dp[i][j] = dp[i-1][j];
        }  else {
          dp[i][j] = Math.max(val[i] + dp[i-1][j - wt[i]], dp[i-1][j]);
        }
      }
    }

    return dp[n-1][weight];
  }
}