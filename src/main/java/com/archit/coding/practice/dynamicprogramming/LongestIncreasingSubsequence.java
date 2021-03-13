package com.archit.coding.practice.dynamicprogramming;

public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
    int n = arr.length;
    System.out.println("Length of lis is "
        + lis( arr, n ) + "\n" );
  }

  private static int lis(int[] a, int n) {
    int dp[] = new int[n];

    //initially if there is one elemnent then longest increasing subsequence is 1
    dp[0] = 1;

    int max = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (a[j] < a[i]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
