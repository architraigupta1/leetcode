package com.archit.coding.practice;

import java.util.Stack;

public class MaxAreaUnderHistogram {
  public static void main(String[] args) {
    int [] hist = new int[] {3,2,5,6};
    Stack<Integer> stack = new Stack<>();
    int maxArea = Integer.MIN_VALUE;
    int i = 0;
    for (i = 0; i < hist.length; i++) {
      if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && hist[i] < hist[stack.peek()]) {
          int miniumBarIndex = stack.pop();
          int area = hist[miniumBarIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
          if (area > maxArea) {
            maxArea = area;
          }
        }
        stack.push(i);
      }
    }

    while (!stack.isEmpty()) {
      int miniumBarIndex = stack.pop();
      int area = hist[miniumBarIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
      if (area > maxArea) {
        maxArea = area;
      }
    }

    System.out.println("max area = " + maxArea);
  }
}
