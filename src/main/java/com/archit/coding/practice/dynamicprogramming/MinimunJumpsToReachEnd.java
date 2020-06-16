package com.archit.coding.practice.dynamicprogramming;

import java.util.Arrays;

public class MinimunJumpsToReachEnd {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 0, 3, 2, 3, 6, 8, 9, 5 };
    int size = arr.length;
    System.out.println("Minimum number of"
        + " jumps to reach end is " + minJumps(arr, size));
  }

  private static int minJumps(int[] a, int n) {
    int[] dp = new int[n];
    int[] parent = new int[n];

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    parent[0] = -1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (j + a[j] >= i) {
          dp[i] = Math.min(dp[i], 1 + dp[j]);
        }
      }
    }

    return dp[n-1];

  }
}
