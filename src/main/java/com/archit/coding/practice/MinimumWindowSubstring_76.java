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

      //prepare tmap char count
      Map<Character, Integer> tmap = new HashMap<>();
      for (int i = 0; i < tlen; i++) {
        int count = tmap.getOrDefault(t.charAt(i), 0);
        tmap.put(t.charAt(i), count + 1);
      }

      int distinct = 0;
      Map<Character, Integer> smap = new HashMap<>();
      int left = 0;
      int right = 0;
      int start = left;
      int minWindow = Integer.MAX_VALUE;

      //until we have searched the whole string
      while(right < slen) {

        //until we have scanned the whole string AND not found a window
        while(right < slen && distinct != tmap.size()) {
          //get the rightmost char
          char rightChar = s.charAt(right);

          //if the char is not in t, increment the window
          if (!tmap.containsKey(rightChar)) {
            right++;
            continue;
          }

          int sRightCount = smap.getOrDefault(rightChar, 0);
          sRightCount++;
          smap.put(rightChar, sRightCount);

          int tRightCount = tmap.get(rightChar);

          //if we found one char equal to the required freq
          if (sRightCount == tRightCount) {
            distinct++;
          }

          //we have found one window, check if it is minimum
          if (distinct == tmap.size() && minWindow > (right - left + 1)) {
            minWindow = right - left + 1;
            start = left;
          }
          right++;
        }

        //we have found one window, compress from the left
        while(right > left && distinct == tmap.size()) {
          char leftChar = s.charAt(left);

          //if leftChar is not in t, compress the window
          if(!tmap.containsKey(leftChar)) {
            left++;
            continue;
          }

          int leftCount = smap.get(leftChar);
          leftCount--;

          if(leftCount == 0) {
            smap.remove(leftChar);
          } else {
            smap.put(leftChar, leftCount);
          }

          int tLeftCount = tmap.get(leftChar);
          if (leftCount < tLeftCount) {
            distinct--;
          }
          minWindow = Math.min(minWindow, right - left);
          start = left;
          left++;
        }
      }

      return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindow);
    }
  }
}
