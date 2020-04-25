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
      Map<Character, Integer> hash = new HashMap<>();
      hash.put('I', 1);
      hash.put('V', 5);
      hash.put('X', 10);
      hash.put('L', 50);
      hash.put('C', 100);
      hash.put('D', 500);
      hash.put('M', 1000);

      int length = s.length();
      if (length < 1) {
        return 0;
      }
      int result = hash.get(s.charAt(0));
      for(int i = 1; i < length; i++ ) {
        result += hash.get(s.charAt(i)); //add the value first
        char current = s.charAt(i); // get current character
        char previous = s.charAt(i-1); //get previous character

        //check for exceptional case in previous + current combinations
        switch (current) {
          case 'V':
          case 'X':
            if (previous == 'I') {
              result-= (2*hash.get(previous));
            }
            break;
          case 'L':
          case 'C':
            if (previous =='X') {
              result-= (2*hash.get(previous));
            }
            break;
          case 'D':
          case 'M':
            if (previous == 'C') {
              result-= (2*hash.get(previous));
            }
            break;
          default: break;
        }
      }
      return result;
    }

  }
}
