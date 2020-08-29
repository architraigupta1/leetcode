package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.subsets(new int [] {1,2,3});
    System.out.println();
  }

  static class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null) {
        return result;
      }

      int n = nums.length;
      makeSet(nums, n, 0, new ArrayList<>(), result);
      return result;
    }

    private void makeSet(int[] nums, int n, int index,
                         List<Integer> set, List<List<Integer>> result) {
      result.add(set);
      if (index == n) {
        return;
      }

      for (int i = index; i < n; i++) {
        List<Integer> copy = new ArrayList<>(set);
        copy.add(nums[i]);
        makeSet(nums, n, i + 1, copy, result);
      }

    }
  }
}
