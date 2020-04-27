package com.archit.coding.leetcode;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 41.7 MB, less than 16.49% of Java online submissions for Remove Duplicates from Sorted Array.
 */
public class RemoveDuplicatesFromSortedArray_26 {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int nums [] = new int[] {0,0,1,1,1,2,2,3,3,4};
    print(nums, nums.length);
    int newLength = solution.removeDuplicates(nums);
    System.out.println("new length : " + newLength);
    print(nums, newLength);
  }

  public static void print(int [] nums, int length) {
    for (int i = 0; i < length; i++) {
      System.out.println(nums[i]);
    }
  }
  static class Solution {
    public int removeDuplicates(int[] nums) {
      int i = 0;
      int j = 1;
      int lenth = nums.length;
      while (j < lenth) {
        while(j < lenth && nums[i] == nums[j]) {
          j++;
        }
        if (j < lenth) {
          nums[i+1] = nums[j];
          i++;
        }
      }
      return i+1;
    }
  }
}
