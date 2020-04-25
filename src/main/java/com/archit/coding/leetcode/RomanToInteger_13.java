package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {
/*
  Symbol       Value
  I             1
  V             5
  X             10
  L             50
  C             100
  D             500
  M             1000

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
*/
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.romanToInt("MCMXCIV"));
  }
  private static class Solution {
    public int romanToInt(String s) {
      int result = 0;
      Map<String, Integer> hash = new HashMap<>();
      hash.put("I", 1);
      hash.put("V", 5);
      hash.put("X", 10);
      hash.put("L", 50);
      hash.put("C", 100);
      hash.put("D", 500);
      hash.put("M", 1000);
      hash.put("IV", 4);
      hash.put("IX", 9);
      hash.put("XL", 40);
      hash.put("XC", 90);
      hash.put("CD", 400);
      hash.put("CM", 900);

      int length = s.length();
      for(int i = 0; i < length; i++ ) {
        char current = s.charAt(i);
        String value = Character.toString(current);
        if (i < length -1) {
          value += Character.toString(s.charAt(i+1));
        }

        if(!hash.containsKey(value)) {
          value = Character.toString(current);
        } else {
          i++;
        }

        result += hash.get(value);
      }
      return result;
    }

  }
}
