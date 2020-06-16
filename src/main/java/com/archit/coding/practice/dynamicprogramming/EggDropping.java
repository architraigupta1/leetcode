package com.archit.coding.practice.dynamicprogramming;

public class EggDropping {
  public static void main(String[] args) {
    int eggs = 2, floors = 36;
    System.out.println("Minimum number of trials in worst"
        + " case with "
        + eggs + "  eggs and "
        + floors + " floors is " + eggDrop(eggs, floors));
  }

  private static int eggDrop(int eggs, int floors) {
    int[][] dp = new int[eggs + 1][floors + 1];

    //case when there is no floor or no egg, it will take minimum 0 attempts
    for (int i = 0; i <= eggs; i++) {
      dp[i][0] = 0;
    }

    //case when there is only one egg then we have to try from every floor
    for (int j = 1; j <= floors; j++) {
      dp[1][j] = j;
    }

    for (int i = 2; i <= eggs; i++) {
      for (int j = 1; j <= floors; j++) {
        if (j < i) {
          dp[i][j] = dp[i-1][j];
        } else {
          int k = 1;
          int min = Integer.MAX_VALUE;
          while(k <= j) {
            min = Math.min(min, 1 + Math.max(dp[i-1][k-1], dp[i][j-k]));
            k++;
          }
          dp[i][j] = min;
        }
      }
    }
    return dp[eggs][floors];
  }
}
