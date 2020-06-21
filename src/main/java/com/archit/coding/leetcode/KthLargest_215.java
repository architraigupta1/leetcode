package com.archit.coding.leetcode;

import java.util.PriorityQueue;

public class KthLargest_215 {
  public static void main(String[] args) {
    int[] a = {3,2,1,5,6,4};
    int k = 2;
    Solution s = new Solution();
    System.out.print(s.findKthLargest(a, k));
  }

  static class Solution {
    public int findKthLargest(int[] nums, int k) {
      int n = nums.length;

      if (n < k) {
        return Integer.MIN_VALUE;
      }

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int count = 0;

      for (int i = 0; i < n; i++) {
        if (count < k) {
          pq.add(i);
          count++;
        } else if (nums[i] > nums[pq.peek()]) {
          pq.poll();
          pq.add(i);
        }
      }

      return pq.peek();
    }
  }
}
