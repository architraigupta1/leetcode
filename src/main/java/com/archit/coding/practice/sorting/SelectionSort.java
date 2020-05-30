package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class SelectionSort {
  public static void main(String[] args) {
    int[] a = ArrayUtil.getRandomArray(13);
    ArrayUtil.printArray(a);

    for (int i = 0; i < a.length; i++) {
      int min = i;
      for (int j = i+1; j < a.length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      ArrayUtil.swap(a, i, min);
    }

    ArrayUtil.printArray(a);
  }
}
