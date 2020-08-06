package com.archit.coding.practice.dynamicprogramming;

public class RegexMatching {
  public static void main(String[] args) {
    String a = "";
    String p = "";

    Solution s = new Solution();
    System.out.println(s.isMatch("mississippi", "mis*is*p*."));
  }

  static class Solution {
    public boolean isMatch(String s, String p) {

      if ((s == null && p == null) || s.isEmpty() && p.isEmpty()) {
        return true;
      }

      if (p.isEmpty()) {
        return s.isEmpty();
      }

      int slen = s.length();
      int plen = p.length();

      boolean[][] dp = new boolean[slen+1][plen+1];

      //empty string and pattern match
      dp[0][0] = true;

      //empty pattern and string do not match
      //so all dp[i][0] should be false which is default.

      //empty string and pattern can match (a*, a*b*, a*b*c*)
      //'*' will always be at even position.
      //Also, dp[0][j] = dp[0][j-2] if j = '*' as '*' will
      //match zero occurences.
      for(int j = 2; j <= plen; j++) {
        if(p.charAt(j-1) == '*' && dp[0][j-2]) {
          dp[0][j] = true;
        }
      }

      for(int i = 1; i <= slen; i++) {
        for (int j = 1; j <= plen; j++) {
          if (s.charAt(i-1) == p.charAt(j-1)
              || p.charAt(j-1) == '.') {
            dp[i][j] = dp[i-1][j-1];
          } else if (p.charAt(j-1) == '*') {
            if(dp[i][j-2]) { //Ignore x* in pattern and continue
              dp[i][j] = dp[i][j-2];
            } else if (s.charAt(i-1) == p.charAt(j-2)
                || p.charAt(j-2) == '.') {
              dp[i][j] = dp[i-1][j];
            }
          } else {
            dp[i][j] = false;
          }
        }
      }

      return dp[slen][plen];


    }

  }
}
