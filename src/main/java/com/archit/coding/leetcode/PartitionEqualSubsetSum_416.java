package com.archit.coding.leetcode;

public class PartitionEqualSubsetSum_416 {
  public static void main(String[] args) {
    Solution s = new Solution();
//    int[] a = {23,13,11,7,6,5,5};
    int[] a = {1,2,5};
    System.out.println(s.canPartition(a));
  }

  static class Solution {
    public boolean canPartition(int[] nums) {
      //can be broken into two empty sets
      if (nums == null || nums.length == 0) {
        return false;
      }

      int n = nums.length;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += nums[i];
      }

      if (sum % 2 != 0) {
        return false;
      }

      int target = sum/2;

      int[] dp = new int[target + 1];

      //when there is only 1 element in the array, if the target is equal to
      //that element then we can make it otherwise not
      for (int j = 0; j <= target; j++) {
        if (j == nums[0]) {
          dp[j] = 1;
          break;
        }
      }

      for (int i = 1; i < n; i++) {
        for (int j = 1; j <= target; j++) {
          if (j == nums[i]) {
            dp[j] = 1;
          } else if (j > nums[i] && dp[j - nums[i]] != 0){
            dp[j] = 1 + dp[j-nums[i]];
          }
        }
      }

      return dp[target] == 0 || dp[target] == n ? false : true;
    }
  }
}
