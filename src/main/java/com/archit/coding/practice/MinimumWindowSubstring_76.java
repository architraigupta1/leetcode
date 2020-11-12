package com.archit.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minWindow("cabwefgewcwaefgcf", "cae"));
  }
  static class Solution {
    public String minWindow(String s, String t) {
      if (s == null || t == null || s.length() < t.length()) {
        return "";
      }

      int slen = s.length();
      int tlen = t.length();
      Map<Character, Integer> tmap = new HashMap<>();
      Map<Character, Integer> smap = new HashMap<>();
      for (int i = 0; i < tlen; i++) {
        char ch = t.charAt(i);
        int count = tmap.getOrDefault(ch, 0);
        tmap.put(ch, count + 1);
      }

      int start = 0;
      int minWindow = Integer.MAX_VALUE;
      int left = 0;
      int right = 0;
      int formed = 0;

      while(right < slen) {
        char ch = s.charAt(right);
        if (!tmap.containsKey(ch)) {
          right++;
          continue;
        }

        int scount = smap.getOrDefault(ch, 0);
        scount++;
        smap.put(ch, scount);

        if (scount == tmap.get(ch).intValue()) {
          formed++;
        }

        while(formed == tmap.size() && left <= right) {
          if (minWindow < right - left + 1) {
            start = left;
            minWindow = right - left + 1;
          }
          ch = s.charAt(left);
          if (!tmap.containsKey(ch)) {
            left++;
            continue;
          }
          scount = smap.get(ch);
          scount--;
          smap.put(ch, scount);

          if (scount < tmap.get(ch).intValue()) {
            formed--;
          }
          left++;
        }
        right++;
      }

      return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindow);
    }
  }
}
