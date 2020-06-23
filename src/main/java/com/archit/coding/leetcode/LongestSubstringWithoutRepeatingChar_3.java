package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringWithoutRepeatingChar_3 {
  public static void main(String[] args) {
    String str = "abcabcbb";
    Solution s = new Solution();
    System.out.print(s.lengthOfLongestSubstring(str));
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.isEmpty()) {
        return 0;
      }

      if (s.length() == 1) {
        return 1;
      }

      int n = s.length();
      int start = 0;
      HashMap<Character, Integer> map = new HashMap();
      map.put(s.charAt(0), 0);
      int max = 1;
      for(int i = 1; i < n; i++) {
        if (!map.containsKey(s.charAt(i))) {
          map.put(s.charAt(i), i);
          continue;
        } else {
          max = Math.max(max, i - start);
          if (start <= map.get(s.charAt(i))) {
            start = map.get(s.charAt(i)) + 1;
          }
          map.put(s.charAt(i), i);
        }
      }

      max = Math.max(max, n - start);
      return max;
    }
  }
}
