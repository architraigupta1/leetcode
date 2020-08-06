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

    //case when there is no floor, it will take minimum 0 attempts
    for (int i = 0; i <= eggs; i++) {
      dp[i][0] = 0;
    }

    //case when there is only one egg then we have to try from every floor
    for (int j = 1; j <= floors; j++) {
      dp[1][j] = j;
    }

    for (int i = 2; i <= eggs; i++) {
      for (int j = 1; j <= floors; j++) {
        //if we have more eggs than floors, then the number of ways is
        // same as the number of ways without this extra egg.
        if (j < i) {
          dp[i][j] = dp[i-1][j];
        } else {
          int k = 1;
          int min = Integer.MAX_VALUE;
          //we need to check from floor 1 to j with i eggs
          while(k <= j) {
            //We want the minimum out of all the possibilities,
            // as we are interseted in minimum number of tries.
            min = Math.min(min,
                // we make 1 attempt
                1 +
                //We take max of the two possibilities as we are
                // looking at the worst case scenario
                Math.max(
                // case when the egg breaks
                //  - we have i-1 remaining eggs
                //  - we have k-1 floors to test, egg breaks when thrown from kth floor
                dp[i-1][k-1],
                // case when the egg doesn't break
                // - we still have i eggs
                // - we have j - k floors to test as egg doesn't break from kth floor
                dp[i][j-k]));
            k++;
          }
          dp[i][j] = min;
        }
      }
    }
    return dp[eggs][floors];
  }
}
