package com.archit.coding.leetcode;

public class SearchInSortedArray_33 {
  public static void main(String[] args) {
    int a[] = {5,1,3};
    int sum = 5;
    Solution s = new Solution();
    System.out.print(s.search(a, sum));
  }
  static class Solution {
    public int search(int[] nums, int target) {
      // find the pivot point (point where both prev and next elem are smaller)
      //1.  array left to pivot is in asc and array right also in asc
      //2. Binary search. If target == pivot return
      //3. if target  > a[left] && target < pivot, search in left, else in right

      if (nums == null || nums.length == 0) {
        return -1;
      }

      if (nums.length == 1) {
        return target == nums[0] ? 0 : -1;
      }

      int n = nums.length;
      int low = 0;
      int high = n - 1;
      int pivot = -1; // if array is sorted (asc/desc)
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (mid+1 < n && nums[mid] > nums[mid + 1]) {
          pivot = mid;
          break;
        }
        if (nums[low] <= nums[mid]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }


      low = 0;
      high = n -1;

      if (pivot == -1) {
        pivot = low + (high - low) / 2;
      }

      while(low <= high) {
        if (nums[pivot] == target) {
          return pivot;
        } else if (target >= nums[low] && target <= nums[pivot]) {
          high = pivot - 1;
        } else {
          low = pivot + 1;
        }

        pivot = low + (high - low) / 2;
      }

      return -1;

    }
  }
}
