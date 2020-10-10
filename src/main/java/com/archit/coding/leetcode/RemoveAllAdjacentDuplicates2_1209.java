package com.archit.coding.leetcode;

public class RemoveAllAdjacentDuplicates2_1209 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.removeDuplicates("deeedbbcccbdaa", 3));
  }

  static class Solution {
    public String removeDuplicates(String s, int k) {
      if (s == null || s.length() == 0 || k < 2 ) {
        return "";
      }

      StringBuilder sb = new StringBuilder(s);
      int i = 0;
      while(i < sb.length() - 1) {
        if (sb.charAt(i) == sb.charAt(i+1)) {
          int j = i;
          int count = 1;
          while (j < sb.length() - 1 && sb.charAt(j) == sb.charAt(j+1) && count < k) {
            j++;
            count++;
          }
          if (count == k) {
            sb.delete(i, j+1);
            i = 0;
          } else {
            i++;
          }
        } else {
          i++;
        }
      }

      return sb.toString();
    }
  }
}
