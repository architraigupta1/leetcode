package com.archit.coding.test;

public class BasicCalculator2 {
  public static void main(String[] args) {
    System.out.println(calculate("3/2"));
  }

  public static int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

        /*
            - This solution scans the string left to right
            - If the current char is a digit, we expand right and make
            a number.
            - we keep track of prev (operator, operand) and on encountering next operator
                - we apply the prev operator on the operand and stack top
        */
    int n = s.length();
    int result = 0;
    int prevOperand = 0;
    char prevOp = '+';
    int top = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == ' ') {
        continue;
      } else if (isOperand(ch)) {
        if (prevOp == '+') {
          result += top;
          top = prevOperand;
        } else if (prevOp == '-') {
          result += top;
          top = -prevOperand;
        } else if (prevOp == '*') {
          top = prevOperand * top;
        } else if (prevOp == '/') {
          top = top / prevOperand;
        }
        prevOp = ch;
      } else {
        int sum = ch - '0';
        while(i + 1 < n && Character.isDigit(s.charAt(i+1))) {
          sum = sum * 10 + (s.charAt(i+1) - '0');
          i++;
        }
        prevOperand = sum;
      }
    }
    if (prevOp == '+') {
      result += top;
      top = prevOperand;
    } else if (prevOp == '-') {
      result += top;
      top = -prevOperand;
    } else if (prevOp == '*') {
      top = prevOperand * top;
    } else if (prevOp == '/') {
      top = top / prevOperand;
    }
    result += top;
    return result;

  }

  private static boolean isOperand(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
  }
}
