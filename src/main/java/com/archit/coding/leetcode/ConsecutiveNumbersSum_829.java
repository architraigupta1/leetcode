package com.archit.coding.leetcode;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumbersSum_829 {
  public static void main(String[] args) {
    Solution s = new Solution();
    Instant start = Instant.now();
    List<List<Integer>> r = s.consecutiveNumbersSum(1000);
    System.out.println(Instant.now().toEpochMilli() - start.toEpochMilli());
  }

  static class Solution {
    public List<List<Integer>> consecutiveNumbersSum(int n) {
      if (n < 3) {
        return new ArrayList<>();
      }

      int half = n/2 + 1;
      int count = 1; //for itself
      List<List<Integer>> result = new ArrayList<>();
      for (int i = half; i >= 0; i--) {
        int sum = 0;
        int j = i;
        List<Integer> list = new ArrayList<>();
        for (; j >= 0; j--) {
          sum += j;
          list.add(j);
          if (sum == n) {
            count++;
            result.add(list);
            break;
          } else if (sum > n) {
            break;
          }
        }

        //this means that we included numbers all the way till 1 to form the sum
        // beginning with any number lower than this can never form the sum
        if (j < 0) {
          break;
        }
      }

      return result;
    }
  }
}
