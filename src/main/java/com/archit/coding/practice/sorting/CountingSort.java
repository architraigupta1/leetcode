package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class CountingSort {
  public static void main(String[] args) {
    int[] a = ArrayUtil.getRandomArray(13, 10, true);
    ArrayUtil.printArray(a);

    int[] b = new int[10];

    for (int i = 0; i < a.length; i++) {
      b[a[i]] = b[a[i]] + 1;
    }

    ArrayUtil.printArray(b);
    int i = 0;
    for (int k = 0; k < b.length; k++) {

      while (b[k] > 0) {
        a[i] = k;
        b[k]--;
        i++;
      }
    }
    ArrayUtil.printArray(a);
  }
}
