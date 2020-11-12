package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_166 {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.fractionToDecimal(-50, 8));
  }

  static class Solution {
    /*
    Three cases possible
    1. Num % denominator == 0, return num/den
    2. Num > Den, divide and then it becomes case 3
    3. Num < Den, add decimal points and keep a track of all the remainders.

    Edge cases
    1. Integer.MIN_VALUE / -1
    2. Identify the sign of result before hand
    3. Bring all the numbers to the same domain (negative)
    */
    public static String fractionToDecimal(int numerator, int denominator) {
      if (numerator == 0) {
        return "0";
      }

      //the only overflow case
      if (numerator == Integer.MIN_VALUE && denominator == -1) {
        return String.valueOf(Integer.MIN_VALUE).substring(1);
      }

      if (denominator == 1) {
        return String.valueOf(numerator);
      }

      boolean negative = false;
      if ((numerator > 0 && denominator < 0)
          || (numerator < 0 && denominator > 0)) {
        negative = true;
      }

      StringBuilder sb = new StringBuilder();
      String sign = negative ? "-" : "";
      sb.append(sign);

      if (numerator % denominator == 0) {
        sb.append(numerator/denominator);
        return sb.toString();
      }

      if (numerator > denominator) {
        sb.append(numerator/denominator).append(".");
        numerator = numerator % denominator;
      } else {
        sb.append("0.");
      }
      numerator *= 10;
      return solveDecimal(numerator, denominator, sb);
    }

    private static String solveDecimal(int numerator, int denominator, StringBuilder sb) {
      Map<Integer, Integer> map = new HashMap<>();
      int index = sb.length();

      while (numerator != 0) {
        if (map.containsKey(numerator)) {
          StringBuilder result = new StringBuilder();
          index = map.get(numerator);
          result.append(sb.substring(0, index))
              .append("(")
              .append(sb.substring(index))
              .append(")");
          return result.toString();
        } else {
          map.put(numerator, index);
          index++;
          if (numerator > denominator) {
            sb.append(numerator/denominator);
            numerator = numerator % denominator;
          } else {
            sb.append("0");
          }
          numerator *= 10;
        }
      }

      return sb.toString();
    }
  }
}
