package com.archit.coding.leetcode;

import com.archit.coding.utils.ArrayUtil;

import java.util.Arrays;

public class NextPermutation_31 {
  public static void main(String[] args) {
    int[] a = {1,2, 3};
    Solution s = new Solution();
    s.nextPermutation(a);
    ArrayUtil.printArray(a);
  }

  static class Solution {
    public void nextPermutation(int[] nums) {
      int n = nums.length;
      if (n < 2 ) {
        return;
      }

      int i = n -2;
      boolean sorted = true;
      for (; i >= 0; i--) {
        if (nums[i] < nums[i+1]) {
          int nextGreater = getNextGreater(nums, i);
          swap(nums, i, nextGreater);
          reverse(nums, i+1);
          sorted = false;
          break;
        }
      }

      if (sorted) {
        Arrays.sort(nums);
      }
    }

    public int getNextGreater(int[] nums, int index) {
      int diff = Integer.MAX_VALUE;
      int element = nums[index];
      int result = nums.length;
      for (int i = index + 1; i < nums.length; i++) {
        if (diff > Math.abs(element - nums[i])) {
          diff = Math.abs(element - nums[i]);
          result = i;
        }
      }

      return result;
    }

    public void reverse(int[] nums, int index) {
      int j = nums.length - 1;
      while(index < j) {
        int t = nums[index];
        nums[index] = nums[j];
        nums[j] = t;
        index++;
        j--;
      }
    }

    public void swap(int[] nums, int a, int b) {
      int t = nums[a];
      nums[a] = nums[b];
      nums[b] = t;
    }
  }
}
