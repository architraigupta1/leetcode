package com.archit.coding.leetcode;

import java.util.Stack;

public class TrappingRainWater_42 {
  public static void main(String[] args) {
    int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    Solution s = new Solution();
    System.out.println(s.trapBruteForce(height));
    System.out.println(s.trapDp(height));
    System.out.println(s.trapStack(height));
    System.out.println(s.twoPointerApproach(height));

  }

  static class Solution {


    public int trapBruteForce(int[] height) {
      int sum = 0;
      int n = height.length;

      for(int i = 0; i < n; i++) {
        int leftMax = 0;
        for (int j = i -1; j >= 0; j--) {
          leftMax = Math.max(leftMax, height[j]);
        }

        int rightMax = 0;
        for (int j = i+1; j < n; j++) {
          rightMax = Math.max(rightMax, height[j]);
        }

        int minHeight = Math.min(leftMax, rightMax);
        int curSum = minHeight - height[i];
        sum = sum + Math.max(curSum, 0);
      }
      return sum;
    }

    public int trapDp(int[] height) {
      int sum = 0;
      int n = height.length;

      int [] leftMax = new int[n+1];
      int[] rightMax = new int[n+1];

      for (int i = 0; i < n; i++) {
        leftMax[i+1] = Math.max(leftMax[i], height[i]);
      }


      for (int i = n-1; i > 0; i--) {
        rightMax[i-1] = Math.max(rightMax[i], height[i]);
      }

      for (int i = 0; i < n; i++) {
        int min = Math.min(leftMax[i], rightMax[i]);
        int cur = min - height[i];
        sum += Math.max(cur, 0);
      }

      return sum;
    }

    public int trapStack(int[] height) {
      int sum = 0;
      if (height == null || height.length == 0) {
        return sum;
      }

      int n = height.length;
      Stack<Integer> stack = new Stack<>();
      int i = 0;
      while (i < n) {
        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
          int top = stack.pop();
          if (stack.isEmpty()) {
            break;
          }

          int d = i - stack.peek() - 1;
          int min = Math.min(height[i], height[stack.peek()]) - height[top];

          sum += d * min;
        }
        stack.push(i);
        i++;
      }

      return sum;
    }

    public int twoPointerApproach(int[] height) {
      int sum = 0;
      if (height == null || height.length == 0) {
        return sum;
      }

      int n = height.length;
      int left = 0;
      int right = n-1;
      int leftMax = 0;
      int rightMax = 0;
      // Take two pointers one in left and one in right.
      // the min(leftMax, rightMax) will decide how much water the current bar can hold.
      // if (a[left] < a[right]) means right is larger, increment left
      // if (a[right] >= a[left]) means left is larger, decrement right
      // now in left, if a[left] > leftMax then it cannot hold any water but will act as a wall for other lefts, so update leftMax. Otherwise, update sum with leftMax as wall - current height
      while(left < right) {
        if (height[left] < height[right]) {
          if(height[left] >= leftMax) {
            leftMax = height[left];
          } else {
            sum += leftMax - height[left];
          }
          left++;
        } else {
          if(height[right] >= rightMax) {
            rightMax = height[right];
          } else {
            sum += rightMax - height[right];
          }
          right--;
        }
      }

      return sum;
    }
  }
}
