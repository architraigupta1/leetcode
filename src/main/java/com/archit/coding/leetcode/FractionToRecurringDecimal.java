package com.archit.coding.leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.fractionToDecimal(Integer.MIN_VALUE, 1));
  }

  static class Solution {
    /*
        case 1: num >= den
            - divide and get the remainder, then it becomes case 2
        case 2: num < den
            - Keep adding 0 to quo and to the numerator until num > den
    */
    public String fractionToDecimal(int num, int den) {
      long numerator = num;
      long denominator = den;
      if (numerator == 0) {
        return "0";
      }

      //only case where overflow might happen
      if (numerator == Integer.MIN_VALUE && denominator == -1) {
        String maxNeg = String.valueOf(Integer.MIN_VALUE);
        return maxNeg.substring(1);
      }

      boolean sign = false; // false represents negative
      if (numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0) {
        sign = true; //true represents positive
      }

      //make both numerator & denominator negative
      if (numerator > 0) {
        numerator = -numerator;
      }

      if (denominator > 0) {
        denominator = -denominator;
      }

      StringBuilder sb = new StringBuilder();
      //add the sign of final result
      if (!sign) {
        sb.append("-");
      }

      //perfectly divisible
      if (numerator % denominator == 0) {
        sb.append(numerator/denominator);
        return sb.toString();
      }

      //add digits before decimal point
      if (numerator < denominator) {
        sb.append(numerator/denominator).append(".");
      } else {
        sb.append("0.");
      }

      //update numerator and solve for deciaml
      numerator = (numerator % denominator) * 10;
      return solveDecimal(numerator, denominator, sb);
    }

    private String solveDecimal(long numerator, long denominator, StringBuilder sb) {
      //store what numerator occurred at what index
      HashMap<Long, Integer> map = new HashMap<>();
      int index = sb.length();

      while (numerator != 0) {
        if (map.containsKey(numerator)) {
          int start = map.get(numerator);
          String result = sb.toString();
          String first = result.substring(0, start);
          String second = result.substring(start);
          return first + "(" + second + ")";
        }
        map.put(numerator, index);
        index++;
        if (numerator <= denominator) {
          sb.append(numerator / denominator);
          numerator = (numerator % denominator) * 10;
        } else {
          sb.append("0");
          numerator *= 10;
        }
      }

      return sb.toString();
    }
  }

  /*
  static class Solution {
    public String fractionToDecimal(long numerator, long denominator) {
      if (numerator == 0) {
        return "0";
      }

      if (numerator < 0 && denominator < 0) {
        return fractionToDecimal(-numerator, -denominator);
      }

      if (numerator < 0 || denominator < 0) {
        return "-" + fractionToDecimal(Math.abs(numerator), Math.abs(denominator));
      }

      if (numerator % denominator == 0) {
        return Long.toString(numerator / denominator);
      }

      if (numerator > denominator) {
        return (numerator / denominator) + "." + solveDecimal(numerator % denominator * 10, denominator);
      }

      return "0." + solveDecimal(numerator * 10, denominator);
    }

    private String solveDecimal(long numerator, long denominator) {
      StringBuilder builder = new StringBuilder();
      Map<Long, Integer> map = new HashMap<>();
      int index = 0;

      while (numerator != 0) {
        if (map.containsKey(numerator)) {
          int start = map.get(numerator);
          String substring = builder.toString().substring(start);
          String before = builder.toString().substring(0, start);

          return before + "(" + substring + ")";
        }
        map.put(numerator, index++);

        if (numerator < denominator) {
          builder.append(0);
          numerator *= 10;
        } else {
          builder.append(numerator / denominator);
          numerator %= denominator;
          numerator *= 10;
        }
      }

      return builder.toString();
    }
  }

   */
}
