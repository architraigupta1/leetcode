package com.archit.coding.test;

import java.util.Stack;

public class BasicCalculator3 {
  public static void main(String[] args) {
    System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); //-12
    //(2+18+5 - 40) + 3
    //
  }

  public static int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int n = s.length();
    int prevOperand = 0;
    char prevOp = '+';
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == ' ') {
        continue;
      } else if (isOperand(ch)) {
        applyPrevOperand(prevOp, prevOperand, stack);
        prevOp = ch;
      } else if (Character.isDigit(ch)) {
        int sum = ch - '0';
        while(i + 1 < n && Character.isDigit(s.charAt(i+1))) {
          sum = sum * 10 + (s.charAt(i+1) - '0');
          i++;
        }
        prevOperand = sum;
      } else if (ch == '(') {
        //recursively calculate it's result
        int level = 1;
        int j = i+1;
        while(j < n && level > 0) {
          ch = s.charAt(j);
          if (ch == '(') {
            level++;
          } else if (ch == ')') {
            level--;
          }
          j++; // in the end j will point to char next to ')'
        }


        //consume current set of paranthesis and calculate result
        int block = calculate(s.substring(i+1, j-1));
        i = j-1;
        prevOperand = block;
      }
    }

    applyPrevOperand(prevOp, prevOperand, stack);
    int result = 0;
    while(!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
  }

  private static void applyPrevOperand(char prevOp, int prevOperand,
                                Stack<Integer> stack) {
    if (prevOp == '+') {
      stack.push(prevOperand);
    } else if (prevOp == '-') {
      stack.push(-prevOperand);
    } else if (prevOp == '*') {
      int top = stack.pop();
      stack.push(top * prevOperand);
    } else if (prevOp == '/') {
      int top = stack.pop();
      stack.push(top / prevOperand);
    }


  }
  private static boolean isOperand(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
  }
}
