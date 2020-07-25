package com.archit.coding.leetcode;

import java.util.Stack;
//
//"()(()"
//    "(()"
//    ")()())"
//    "()"
//    ")))"
//    "((("
//    "(((())(()()"
//    "()()()(((((())))()()((()))))(("
public class LongestValidParanthesis_32 {
  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "()()()";
    System.out.println(s.longestValidParentheses(str));
  }

  static class Solution {
    public int longestValidParentheses(String s) {
      if (s == null || s.length() < 2) {
        return 0;
      }

      StringBuilder sb = sanitizeString(s);
      int n = sb.length();
      int[] memo = new int[n];
      Integer max = 0;
      for (int i = 0; i < n; i++) {
        int sum = check(sb, i, n, max, memo);
        max = Math.max(max, sum);
      }

      return max;
    }

    private int check(StringBuilder sb, int start, int end, Integer max, int[] memo) {
      Stack<Integer> stack = new Stack<>();
      int i = start;
      int sum = 0;
      while(i < end) {
        if (memo[i] != 0) {
          sum += memo[i];
          i += memo[i];
          continue;
        }
        if (sb.charAt(i) == '(') {
          stack.push(i);
        } else {
          if (!stack.isEmpty() && sb.charAt(stack.peek()) == '(') {
            stack.pop();
            //we have found a valid substring
            if (stack.isEmpty()) {
              int curSum = i - start + 1;
              memo[start] = curSum;
              sum += curSum;
              start = i + 1;
            }
          } else {
            break;
          }
        }
        i++;
      }
      return sum;
    }

    private StringBuilder sanitizeString(String s) {
      int n = s.length();
      int i = 0;
      //remove starting ')' and trailing '(' as they
      // will never contribute to valid parans
      while(i < n && s.charAt(i) == ')') {
        i++;
      }

      s = s.substring(i);
      n = s.length();
      i = n - 1;
      while(i >= 0 && s.charAt(i) == '(') {
        i--;
      }
      s = s.substring(0, i+1);

      return new StringBuilder(s);
    }
  }

/*
A)
For every index i in s.
    - check for valid paranthsis in (i, n-1) using stack
    - Every time stack is empty, it gives us a valid length
- We can skip
    - all the ')' in beginning
    - all the '(' in the end
*/
}
