package com.archit.coding.leetcode;

import java.util.Arrays;

public class LongestSubstringWithAtleastKRepeatingChars_395 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.longestSubstring("aacbbbdc", 2));
  }

  static class Solution {
    public int longestSubstring(String s, int k) {
      if (s == null || s.length() < k) {
        return -1;
      }

      int[] count = new int[26];
      int max = 0;
      int length = s.length();
      for (int l = k; l <= length; l++) {
        for (int i = 0; i <= length - l; i++) {
          int x = i;
          int y = x + l - 1;
          while(x <= y) {
            int index = s.charAt(x) - 'a';
            count[index]++;
            if (count[index] >= k) {
              max = Math.max(max, checkIfMaxUpdated(count, k));
            }
            x++;
          }
          Arrays.fill(count, 0);
        }

      }

      return max;

    }

    static private int checkIfMaxUpdated(int [] count, int k) {
      int sum = 0;
      for (int i = 0; i < 26; i++) {
        if (count[i] != 0 && count[i] < k) {
          return 0;
        }
        sum += count[i];
      }

      return sum;
    }
  }
}
