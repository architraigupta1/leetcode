package com.archit.coding.leetcode;

public class AtoI {
  public static void main(String[] args) {
    System.out.println(myAtoi("4193 with words"));
  }

  static public int myAtoi(String s) {
    // no conversion possible
    if (s == null || s.length() == 0) {
      return 0;
    }

    int n = s.length();
    int i = 0;
    while(i < n) {
      char ch = s.charAt(i);
      if (ch == '+' || ch == '-' || Character.isDigit(ch)) {
        break;
      }
      i++;
    }

    // no conversion possible
    if ( i == n) {
      return 0;
    }

    //extract the sign
    boolean sign = true;
    if (s.charAt(i) == '+' || s.charAt(i) == '-') {
      sign = (s.charAt(i) == '+');
      i++;
    }

    //character after sign is not a number
    if (!Character.isDigit(s.charAt(i))) {
      return 0;
    }

    int num = s.charAt(i) - '0';
    i++;

    while(i < n && Character.isDigit(s.charAt(i))) {
      int lastDigit = s.charAt(i) - '0';
      if (num > (Integer.MAX_VALUE / 10) || num == (Integer.MAX_VALUE / 10) && lastDigit > 7) {
        return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      } else {
        num = num * 10 + lastDigit;
      }
      i++;

    }

    return sign ? num : -num;

  }
}
