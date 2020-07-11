package com.archit.coding.practice.dynamicprogramming;

import com.archit.coding.utils.ArrayUtil;

import java.util.HashSet;
import java.util.Stack;

public class RemoveValidParanthesis {
  public static void main(String[] args) {
    String string = "()())())";

    RemoveValidParanthesis r = new RemoveValidParanthesis();
    ArrayUtil.printArray(r.checkAllSolutions(string));
    r.recursivelyMakeExpressions(string);

  }

  private void recursivelyMakeExpressions(String string) {

  }

  private String[] checkAllSolutions(String string) {
    int n = string.length();
    HashSet<String> set = new HashSet();

    for (int i = 0; i < n; i++) {
      String s1 = string.substring(0, i);
      String s2 = "";
      if (i+1 < n) {
        s2 = string.substring(i+1, n);
      }
      String check = s1+s2;
      if (isValid(check)) {
        set.add(check);
      }

    }
    return set.toArray(new String[set.size()]);
  }

  public boolean isValid(String check) {
    Stack<Character> stack = new Stack();
    for (int i = 0; i < check.length(); i++) {
      char ch = check.charAt(i);
      if (ch == '(') {
        stack.push(ch);
      }

      if (ch == ')') {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      }
    }

    return stack.isEmpty();
  }
}
