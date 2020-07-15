package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minWindow("ADOBECODEBANC"
        ,"ABC"));
  }
  static class Solution {

    public String minWindow(String s, String t) {

      if(s == null || t == null || s.isEmpty() || t.isEmpty()) {
        return "";
      }

      int slen = s.length();
      int tlen = t.length();

      Map<Character, Integer> tcount = new HashMap<>();
      Map<Character, Integer> scount = new HashMap<>();

      //save freq of chars in T
      for(int i = 0; i < tlen; i++) {
        int count = tcount.getOrDefault(t.charAt(i), 0);
        tcount.put(t.charAt(i), count + 1);
      }

      //unique keys in t
      int required = tcount.size();

      //found unique keys in s
      int formed = 0;

      int start = 0;
      int minWindow = Integer.MAX_VALUE;
      int left = 0;
      int right = 0;

      while(right < slen) {
        char c = s.charAt(right);

        //add char to the window
        int sc = scount.getOrDefault(c, 0);
        scount.put(c, sc+1);

        if(tcount.containsKey(c) && tcount.get(c).intValue() == scount.get(c).intValue()) {
          formed++;
        }

        //contract the window
        while(left <= right && formed == required) {
          c = s.charAt(left);

          //save current min window
          if (minWindow > right - left + 1) {
            start = left;
            minWindow = right - left + 1;
          }


          //remove left from the window
          sc = scount.get(c);
          sc = sc - 1;
          scount.put(c, sc);

          int tc = tcount.getOrDefault(c, 0);

          // if the count of char going out of window decresases than the
          // desirable frequency.
          if (tcount.containsKey(c) && (sc < tc)) {
            formed--;
          }

          left++;
        }

        right++;
      }


      return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindow);


    }

  }

/*
A D O B E C O D E B A N C

A - 1
B - 1
C - 1

1. find freq of all chars in T
2. Scan s from left to right until all chars are found for given freq
3. If end of string reached and not all chars found return ""
3. This gives us first minWindow
4. Now Continue scanning S to right
    - if char not in t, continue;
    - if char in t but not the leftmost char, inc freq
    - if char in t is leftmost char
        - while true
        - increment left and remove freq of chars in t going out of window
        - once we reach the min set, save the window length


*/
}
