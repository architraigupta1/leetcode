package com.archit.coding.leetcode;

public class Pow_x_n_50 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.myPow(2.0, 10));

  }

  static class Solution {
    public double myPow(double x, int n) {
      long pow = n;
      if (pow < 0) {
        x = 1/x;
        pow = -pow;
      }

      double ans = 1;
      double prod = x;


      for (long i = pow; i > 0; i /= 2) {
        if (i % 2 != 0) {
          prod = prod * prod;
          ans = ans * x;
        } else {
          prod = prod * prod;
          ans = prod;
        }
      }

      return ans;
    }
  }
}
