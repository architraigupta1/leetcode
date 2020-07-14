package com.archit.coding.leetcode;

public class MaxSumOf3NonOverlappingSubarrays_689 {
  public static void main(String[] args) {
//    Solution s = new Solution();
  }
/*
  static class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
      int length = nums.length;
      int [] posLeft = new int[length];
      int [] posRight = new int[length];
      int[] ans = new int[3];
      int[] sum = new int[length + 1];

      //prepare a sum array s.t sum[i] = sum of all elements left to it.
      for (int i = 0; i < length; i++) {
        sum[i+1] = sum[i] + nums[i];
      }

      int maxLeft = sum[k] - sum[0];
      int maxLeftIndex = 0;
      //prepare posLeft
      // mid array can go from k to n - 2k

      for(int i = k+1; i <= length-2*k; i++) {
        if(sum[i] - sum[i-k] > maxLeft) {
          maxLeft = sum[i] - sum[i-k];
          maxLeftIndex = i - k;
          posLeft[i] = i - k;
        } else {
          posLeft[i] = maxLeftIndex;
        }
      }

      int maxRight = sum[n] - sum[n-k];
      int maxRightIndex = n-k;
      postRight[n-2*k] = n-k;
      for(int i = n-2k-1; i >= k; i--) {
        if (sum[i+2k] - sum[i+k] >= maxRightIndex) {
          maxRightIndex = i + k;
          posRight[i] = i + k;
          maxRightIndex = sum[i+2k] - sum[i+k];
        } else {
          posRight[i] = maxRightIndex;
        }
      }

      int maxSum = 0;
      for (int i = k; i <= n-2k; i++) {
        int l = posLeft[i];
        int r = posRight[i];
        int curSum = (sum[i+k] - sum[k]) + (sum[l+k] - sum[l]) + (sum[r+k] - sum[r]);
        if(curSum > maxSum) {
          ans[0] = l; ans[1] = i; ans[2] = r;
        }
      }

      return ans;
    }
  }

 */

}
