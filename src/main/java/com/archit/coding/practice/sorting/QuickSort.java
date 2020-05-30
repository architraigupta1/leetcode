package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class QuickSort {
  public static void main(String[] args) {
    int[] a = ArrayUtil.getRandomArray(13);
    ArrayUtil.printArray(a);

    quickSort(a, 0, a.length - 1);
    ArrayUtil.printArray(a);
  }

  private static void quickSort(int[] a, int left, int right) {
    if (right > left) {
      int pivot = partition(a, left, right);
      quickSort(a, left, pivot-1);
      quickSort(a, pivot+1, right);
    }
  }

  private static int partition(int[] a, int left, int right) {
    int pivot = a[left];
    int i = left;
    int j = right;
    while(i<j) {
      while (i <= right && a[i] <= pivot) {
        i++;
      }
      while (j >= left && a[j] > pivot) {
        j--;
      }
      if (i < j) {
        ArrayUtil.swap(a, i, j);
      }
    }
    a[left] = a[j];
    a[j] = pivot;
    return j;
  }
}
