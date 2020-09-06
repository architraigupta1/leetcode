package com.archit.coding.utils;

public class MathUtil {
  /**
   *
   * @param num input number
   * @return returns this num if it is a power of 2 or next higher power of 2.
   */
  public static int getNextPowerOfTwo(int num) {
    if (num <= 2) {
      return num;
    }

    int i = 2;
    while(i <= num) {
      i = i * 2;
    }

    return i;
  }
}
