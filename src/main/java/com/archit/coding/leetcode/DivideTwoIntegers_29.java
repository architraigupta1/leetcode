package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers_29 {
  public static void main(String[] args) {

  }

  static class Solution {
    public int divide(int div, int d) {
      if (div == Integer.MIN_VALUE && d == -1) {
        return Integer.MAX_VALUE;
      }

      boolean negative = (div < 0) ^ (d < 0);
      if (div > 0) {
        div = -div;
      }
      if (d > 0) {
        d = -d;
      }

      List<Integer> powers = new ArrayList();
      List<Integer> doubles = new ArrayList();

      int powerOfTwo = -1;
      int value = d;
      int HALF_INT_MIN = Integer.MIN_VALUE >> 1;

      while(value >= div) {
        doubles.add(value);
        powers.add(powerOfTwo);
        if (value < HALF_INT_MIN) {
          break;
        }
        powerOfTwo += powerOfTwo;
        value += value;
      }

      int q = 0;
      for (int i = doubles.size()-1; i >= 0; i--) {
        if (doubles.get(i) >= div) {
          q += powers.get(i);
          div = div - doubles.get(i);
        }
      }
      return negative ? q : -q;
    }
  }
}
