package com.archit.coding.leetcode;

public class LongestPalindromicSubstring_5 {
  public static void main(String[] args) {
    String str = "eabae";
    Solution s = new Solution();
    System.out.println(s.longestPalindrome(str));
  }
  static class Solution {
    public String longestPalindrome(String s) {
      if (s == null || s.isEmpty() || s.length() == 1) {
        return s;
      }

      int n = s.length();
      int start = 0;
      int length = 1;
      int low;
      int high;
      for (int i = 1; i < n; i++) {
        low = i-1;
        high = i;
        while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
          if (high - low + 1 > length) {
            length = high - low + 1;
            start = low;
          }
          low--;
          high++;
        }

        low = i-1;
        high = i+1;
        while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
          if (high - low + 1 > length) {
            length = high - low + 1;
            start = low;
          }
          low--;
          high++;
        }
      }

      StringBuilder sb = new StringBuilder();
      int i = start;
      int j = i + length;
      while(i < j) {
        sb.append(s.charAt(i));
        i++;
      }

      return sb.toString();
//      return s.substring(start, start + length);
    }
  }

}
