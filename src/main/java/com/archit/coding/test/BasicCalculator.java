package com.archit.coding.test;

import java.util.Stack;

public class BasicCalculator {
  public static void main(String[] args) {
//    System.out.println(calculate("1+2"));
//    System.out.println(calculate("-2+1"));
    System.out.println(calculate("12+(-2+1)"));
    System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
  }

  public static int calculate(String s) {
    int n = s.length(), sign = 1, result = 0;
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == ' ') {
        continue;
      } else if (ch == '+') {
        sign = 1;
      } else if (ch == '-') {
        sign = -1;
      } else if (ch == '(') {
        //push the current result and sign to stack
        //so that when a ')' => we have evaluated this (...) block
        //add it to the result => sign * (...) + old result
        stack.push(result);
        stack.push(sign);

        //reset sign and result
        sign = 1;
        result = 0;
      } else if (ch == ')') {
        result = (stack.pop() //last sign
            * result //value of (...) block
            + stack.pop());//old result
      } else {
        int sum = ch - '0';
        while(i+1 < n && Character.isDigit(s.charAt(i+1))) {
          sum = sum * 10 + (s.charAt(i+1) - '0');
          i++;
        }
        result += sign * sum;
      }
    }
//    for (int i = 0; i < len; i++) {
//      if (Character.isDigit(s.charAt(i))) {
//        int sum = s.charAt(i) - '0';
//        while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
//          sum = sum * 10 + s.charAt(i + 1) - '0';
//          i++;
//        }
//        result += sum * sign;
//      } else if (s.charAt(i) == '+')
//        sign = 1;
//      else if (s.charAt(i) == '-')
//        sign = -1;
//      else if (s.charAt(i) == '(') {
//        stack.push(result);
//        stack.push(sign);
//        result = 0;
//        sign = 1;
//      } else if (s.charAt(i) == ')') {
//        result = result * stack.pop() + stack.pop();
//      }
//
//    }
    return result;
  }
}
