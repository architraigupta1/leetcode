package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = s.threeSum(a);
  }

  static class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList();

      if (nums == null || nums.length < 3) {
        return result;
      }

      int n = nums.length;

      Arrays.sort(nums);
      for (int i = 0; i < n && nums[i] <= 0; i++) {
        if (i == 0 || nums[i] != nums[i-1]) {
          findPair(nums, i, result);
        }
      }

      return result;
    }

    public void findPair(int[] nums, int i, List<List<Integer>> result) {
      int l = i+1;
      int h = nums.length - 1;
      while (l < h) {
        int sum = nums[i] + nums[l] + nums[h];
        if (sum < 0 || (l > i+1 && nums[l] == nums[l-1])) {
          l++;
        } else if (sum > 0 || (h < nums.length - 1 && nums[h] == nums[h+1])) {
          h--;
        } else {
          result.add(Arrays.asList(nums[i], nums[l], nums[h]));
          l++;
          h--;
        }
      }
    }
  }
}
