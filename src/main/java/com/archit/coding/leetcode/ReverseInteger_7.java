package com.archit.coding.leetcode;

public class ReverseInteger_7 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.reverse(1534236469));
  }
  static class Solution {
    public int reverse(int x) {
      int reverse = 0;

      while(x!=0) {
        try {
          int lastDigit = x % 10; //extract last digit
          reverse = Math.addExact(Math.multiplyExact(reverse, 10), lastDigit); //Push last digit to reverse number
          x = x / 10; //remove last digit
        } catch (ArithmeticException ex) {
          return 0;
        }
      }
      return reverse;
    }
  }
}
