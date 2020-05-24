package com.archit.coding.practice;

import java.util.Stack;

public class FindingSpanOfElement {
  public static void main(String[] args) {
    int[] a = new int[] {6,3,4,5,2,6};
    int [] span = new int[a.length];

    Stack<Integer> stack = new Stack();
    int p = -1;
    for (int i = 0; i < a.length; i++) {
      while (!stack.isEmpty() && a[i] >= a[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        p = -1;
      } else {
        p = stack.peek();
      }
      span[i] = i - p;
      stack.push(i);
    }

    for (int i = 0; i < a.length; i++) {
      System.out.println("span of " + a[i] + " = " + span[i]);
    }
  }
}
