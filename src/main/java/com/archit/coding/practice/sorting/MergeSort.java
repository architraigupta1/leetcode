package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class MergeSort {
  public static void main(String[] args) {
    int[] a = ArrayUtil.getRandomArray(1);
    ArrayUtil.printArray(a);

    mergeSort(a, 0, a.length-1);

    ArrayUtil.printArray(a);
  }

  private static void mergeSort(int[] a, int left, int right) {
    if (right > left) {
      int mid = (left + right) / 2;
      mergeSort(a, left, mid);
      mergeSort(a, mid + 1, right);
      merge(a, left, mid, right);
    }
  }

  private static void merge(int[] a, int left, int mid, int right) {
    int size = right - left + 1;
    int[] b = new int[size];
    int i = left;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= right) {
      if (a[i] <= a[j]) {
        b[k] = a[i];
        i++;
        k++;
      } else {
        b[k] = a[j];
        j++;
        k++;
      }
    }

    while (i <= mid) {
      b[k] = a[i];
      i++;
      k++;
    }

    while (j <= right) {
      b[k] = a[j];
      k++;
      j++;
    }

    k = size - 1;

    for (int z = right; z >= left; z--) {
      a[z] = b[k];
      k--;
    }
  }
}
