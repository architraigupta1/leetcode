package com.archit.coding.leetcode;

import com.archit.coding.utils.Node;

import java.util.PriorityQueue;

public class Pow_x_n_50 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.myPow(2.0, 5));

  }

  static class Solution {
    public double myPow(double x, int n) {
      long pow = n;
      if (pow < 0) {
        x = 1/x;
        pow = -pow;
      }

      double ans = x;
      long i = 1;
      while (i < pow) {
        ans *= ans;
        i += i;
      }

      while(i > pow) {
        ans/=x;
        i--;
      }
      return ans;
    }
  }
}
