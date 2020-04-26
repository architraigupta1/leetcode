package com.archit.coding.leetcode;

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
Memory Usage: 37.5 MB, less than 92.40% of Java online submissions for Longest Common Prefix.
 */
public class LongestCommonPrefix_14 {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String [] testStrings1 = new String[] {"flower", "flow", "flight"};
    String [] testStrings2 = new String[] {"dog","racecar","car"};
    String [] testStrings3 = new String[] { "aa","a"};
    String [] testStrings4 = new String[] { "aca","cba"};
    System.out.println(solution.longestCommonPrefix(testStrings4));
  }

  static class Solution {
    public String longestCommonPrefix(String[] strs) {
      if(strs.length == 0) {
        return "";
      }
      if (strs.length == 1) {
        return strs[0];
      }
      //vertical scanning
      for (int i = 0; i < strs[0].length(); i++) {
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
          if (i == strs[j].length() || strs[j].charAt(i) != c) {
            return strs[0].substring(0, i);
          }
        }
      }
      return strs[0];
    }
  }
}
