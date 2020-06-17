package com.archit.coding.practice.dynamicprogramming;

public class DecodeAString {
  public static void main(String[] args) {
    char digits[] = {'1','2','3', '4', '5'};
    int n = digits.length;
    System.out.println("Count is " +
        countDecodingDP(digits, n));
  }

  private static int countDecodingDP(char[] a, int n) {
    // if empty string, then there is only 1 way to decode
    if (n == 0) {
      return 1;
    }

    //if first character is 0, then cannot decode
    if (a[0] == '0') {
      return 0;
    }

    int[] dp = new int[n+1];
    dp[0] = 1; //if empty string, then only 1 way
    dp[1] = 1; //if one character, then 1 way

    for (int i = 2; i <= n; i++) {
      //if current character is a valid character, then I have atleast
      // same number of ways to count as if this character wasn't there
      if (a[i-1] > '0') {
        dp[i] = dp[i-1];
      }

      //if current character and previous character form a legit coding, then I have
      // count is equal to first taking only one character and then two chars at a time.
      if (a[i-2] == '1' || a[i-2] == '2' && a[i-1] < '7') {
        dp[i] = dp[i-1] + dp[i-2];
      }
    }

    return dp[n];
  }
}
