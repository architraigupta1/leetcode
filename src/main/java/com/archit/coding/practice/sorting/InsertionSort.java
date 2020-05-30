package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class InsertionSort {
  public static void main(String[] args) {
    int[] a = ArrayUtil.getRandomArray(13);
    ArrayUtil.printArray(a);

    for (int i = 1; i < a.length; i++) {
      int data = a[i];
      int j = i;
      while (j >= 1 && a[j-1] > data) {
        a[j] = a[j-1];
        j--;
      }
      a[j] = data;
    }

    ArrayUtil.printArray(a);
  }
}
