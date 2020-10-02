package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarrySumWithKMultiple {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {23,2,4,6,7};
    int k = 6;
    System.out.println(s.checkSubarraySum(a, k));
  }
  static class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
      if(nums == null || nums.length < 2 ) {
        return false;
      }

      int n = nums.length;
      Map<Integer, Integer> map = new HashMap();
      map.put(0, -1);
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += nums[i];
        if (k != 0) {
          sum = sum % k;
        }
        if (map.containsKey(sum)) {
          if (i - map.get(sum) > 1) {
            return true;
          }
        } else {
          map.put(sum, i);
        }

      }

      return false;
    }
  }
}
