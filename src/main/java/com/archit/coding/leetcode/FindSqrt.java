package com.archit.coding.leetcode;

public class FindSqrt {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.mySqrt(Integer.MAX_VALUE));
  }

  static class Solution {
    public int mySqrt(int x) {
      if (x == 0) {
        return 0;
      }

      if (x < 4) {
        return 1;
      }

      int left = 1;
      int right = x;
      int prevMid = 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int prod = mid * mid;
        if (prod < 0) {
          return prevMid;
        }
        if (prod == x) {
          return mid;
        } else if (prod > x) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        prevMid = mid;
      }

      return left - 1;

        /*
            This method checks all the numbers till i*i becomes greater than x.
            So if x is larger, it is going to check a lot of numbers.
        int halfMax = Integer.MAX_VALUE / 2;
        int sqrt = 1;
        int prod = 1;
        int i = 1;
        while (prod <= x) {

            sqrt = i;

            i++;
            prod = i * i;
            //if prod overflows, then it will become negative. Stop here.
            if (prod < 0) {
                break;
            }

        }


        return sqrt;
        */
    }
  }

}
