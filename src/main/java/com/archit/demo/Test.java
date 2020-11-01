package com.archit.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Stack;

public class Test {
  public static void main(String[] args) throws ParseException {
    SimpleDateFormat parser = new SimpleDateFormat("MM/yyyy");
    SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
    System.out.println(formatter.format(parser.parse("11/2017")));


//    Solution s = new Solution();
    //System.out.println(s.decodeString("3[a]2[bc]"));
  }

  static class Solution {
    public String decodeString(String s) {

      if (s == null || s.length() == 0) {
        return "";
      }

      int n = s.length();
      return decode(s, 0, n);
    }

    private String decode(String s, int index, int n) {
      Stack<String> stack = new Stack<>();

      for (int i = index; i < n; i++) {
        String ch = s.substring(i, i+1);
        if (!ch.equals("]")) {
          stack.push(ch);
        } else {
          StringBuilder sb = new StringBuilder();
          while (!stack.isEmpty() && !stack.peek().equals("[")) {
            sb.append(stack.pop());
          }
          stack.pop();
          int num = 0;
          int pow = 1;
          while(!stack.isEmpty() &&
              Character.isDigit(stack.peek().charAt(0))) {
            int digit = stack.pop().charAt(0) - '0';
            digit = digit * pow;
            pow *= 10;
            num = digit + num;
          }

          String part = sb.toString();
          StringBuilder substr = new StringBuilder();
          for (int j = 0; j < num; j++) {
            substr.append(part);
          }

          stack.push(substr.toString());
        }
      }

      StringBuilder result = new StringBuilder();
      while (!stack.isEmpty()) {
        result.append(stack.pop());
      }

      result = result.reverse();

      return result.toString();
    }
  }
}
