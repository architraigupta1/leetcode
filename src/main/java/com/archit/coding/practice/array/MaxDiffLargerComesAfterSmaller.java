package com.archit.coding.practice.array;

public class MaxDiffLargerComesAfterSmaller {
  public static void main(String[] args) {
    int[] a = {-2, 3, 10, 6, 4, 8, 1};
    int[] b = {7, 9, 5, 6, 3, 2};
    System.out.println(maxDiff(a));
    System.out.println(maxDiff(b));
  }

  public static int maxDiff(int[] a) {
    if (a.length < 2) {
      return -1;
    }

    int min = a[0];
    int diff = Integer.MIN_VALUE;

    for (int i = 1; i < a.length; i++) {
      if (a[i] - min > diff) {
        diff = a[i] - min;
      }
      if (a[i] < min) {
        min = a[i];
      }
    }
    return diff;
  }
}
