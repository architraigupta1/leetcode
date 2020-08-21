package com.archit.coding.leetcode;

public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(Integer.MAX_VALUE));
//    System.out.println(reverse(Integer.MIN_VALUE));
  }

  static public int reverse(int x) {
    if (x < 10 && x > -10) {
      return x;
    }


    int num = x % 10;
    x = x / 10;

    //eat up all trailing zeroes and
    //init num with last non-zero digit of x
    while (x != 0 && num == 0) {
      num = x % 10;
      x = x / 10;
    }

    int i = 1;
    boolean sign = x > 0 ? true : false;
    while(x != 0) {
      int last = x % 10;

      num = (int)(num * Math.pow(10, i)) + last;
      x = x / 10;
      boolean curSign = num > 0 ? true : false;
      if (sign != curSign) {
        return 0;
      }
    }

    return num;
  }
}
