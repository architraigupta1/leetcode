package com.archit.coding.practice.dynamicprogramming;

public class OptimalStrategyToWinGame {
  public static void main(String[] args) {
    int a[] = { 8, 15, 3, 7 };
    int n = a.length;
    Pot[][] moves = optimalStrategyOfGame(a, n);
    printSolution(moves);
  }

  private static void printSolution(Pot[][] moves) {
    for (int i = 0; i < moves.length; i++) {
      for (int j = 0; j < moves[0].length; j++) {
        System.out.print("(" + moves[i][j].first + ", " + moves[i][j].second + ", " + moves[i][j].pick + ")" + "  ");
      }
      System.out.println();
    }
  }

  private static Pot[][] optimalStrategyOfGame(int[] a, int n) {
    Pot[][] dp = new Pot[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = new Pot();
      }
    }

    //case when there is only one element to pick, player one picks it always
    for (int i = 0; i < n; i++) {
      dp[i][i] = new Pot(a[i], 0, i);
    }

    //we pick in groups starting from 2 to n
    for (int l = 2; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (a[i] + dp[i+1][j].second > a[j] + dp[i][j-1].second) {
          dp[i][j].first = a[i] + dp[i+1][j].second;
          dp[i][j].second = dp[i+1][j].first;
          dp[i][j].pick = i;
        } else {
          dp[i][j].first = a[j] + dp[i][j-1].second;
          dp[i][j].second = dp[i][j-1].first;
          dp[i][j].pick = j;
        }
      }
    }

    return dp;
  }

  static class Pot {
    int first; //value that first player gets
    int second; //value that second player gets
    int pick; //item that is picked

    public Pot() {

    }

    public Pot(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public Pot(int first, int second, int pick) {
      this(first, second);
      this.pick = pick;
    }
  }
}
