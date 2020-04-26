package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isValid("{[(]}"));
    System.out.println(solution.isValid("{[()]}"));
  }
  static class Solution {
    public boolean isValid(String s) {
      if (s.length() == 0) {
        return true;
      }
      if (s.length() == 1) {
        return false;
      }
      Stack <Character> stack = new Stack();
      Map<Character, Character> hash = new HashMap<>();
      hash.put('(', ')');
      hash.put('[', ']');
      hash.put('{', '}');

      for (int i = 0; i < s.length(); i++) {
        char currentPar = s.charAt(i);
        if(hash.containsKey(currentPar)) {
          stack.push(currentPar);
          continue;
        }

        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if(currentPar != hash.get(top)) {
          return false;
        }
      }
      return stack.isEmpty();
    }
  }
}
