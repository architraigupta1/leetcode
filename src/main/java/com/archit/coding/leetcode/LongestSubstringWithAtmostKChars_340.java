package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKChars_340 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.lengthOfLongestSubstringKDistinct("eceba", 2));
  }

  static class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

      if (s == null || s.length() == 0 || k == 0) {
        return 0;
      }

      int j = 0;
      int l = 0;
      int max = Integer.MIN_VALUE;
      int count = 0;
      Map<Character, Integer> map = new HashMap();

      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if(map.containsKey(ch)) {
          l++;
          max = Math.max(max, l);
          int c = map.get(ch);
          map.put(ch, c+1);
          continue;
        }
        count++;
        if (count <= k) {
          map.put(ch, 1);
          l++;
          max = Math.max(max, l);
        } else {
          while(j < i) {
            char last = s.charAt(j);
            int c = map.get(last);
            if (c == 1) {
              map.remove(last);
              map.put(ch, 1);
              count--;
              j++;
              break;
            } else {
              j++;
              l--;
              map.put(last, c - 1);
            }
          }
        }
      }

      return max;
    }
  }
}
