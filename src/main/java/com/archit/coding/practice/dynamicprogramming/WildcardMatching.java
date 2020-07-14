package com.archit.coding.practice.dynamicprogramming;

public class WildcardMatching {
  public static void main(String[] args) {
    String a = "xaylmz";
    String pat = "x?y*z";
    boolean[][] dp = new boolean[a.length() + 1][pat.length() + 1];

    // empty string and pattern are a match
    dp[0][0] = true;

    // '*' can match empty string
    if (pat.charAt(0) == '*') {
      dp[0][1] = true;
    }

    //if string is empty and pattern is not
    for (int j = 2; j <= pat.length(); j++) {
      dp[0][j] = false; // this is default by writing it for clarity
    }

    //empty pattern and non-empty string do not match
    for (int i = 1; i <= a.length(); i++) {
      dp[i][0] = false;
    }

    for (int i = 1; i <= a.length(); i++) {
      for (int j = 1; j <= pat.length(); j++) {
        // if chars in both pattern and string match or
        // if current char in pattern is '?' which matches any char in string
        // then we check if the rest of the string & pattern match minus the current char.
        if ((a.charAt(i-1) == pat.charAt(j-1)) || pat.charAt(j-1) == '?') {
          dp[i][j] = dp[i-1][j-1];
         } else if (pat.charAt(j-1) == '*') {
          dp[i][j] = dp[i-1][j] // '*' matches current char, check if remaining string matches.
              || dp[i][j-1]; // '*' represents zero chars, so we check if pattern - '*' matches
        } else {
          dp[i][j] = false;
        }
      }
    }

    System.out.println(dp[a.length()][pat.length()]);
  }
}
