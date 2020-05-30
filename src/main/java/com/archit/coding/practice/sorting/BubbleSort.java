package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class BubbleSort {
  public static void main(String[] args) {
    int[] a = ArrayUtil.getRandomArray(11);
    ArrayUtil.printArray(a);

    boolean swapped = true;
    for (int pass = a.length - 1; pass >=0 && swapped; pass--) {
      swapped = false;
      for (int j = 0; j < pass; j++) {
        if (a[j] > a[j+1]) {
          ArrayUtil.swap(a, j, j+1);
          swapped = true;
        }
      }
    }

    ArrayUtil.printArray(a);
  }
}
