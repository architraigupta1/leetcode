package com.archit.coding.practice.array;

import com.archit.coding.utils.ArrayUtil;

import java.util.Random;

public class QuickSelectKthSmallestElement {
  public static void main(String[] args) {
    int a[] = {12, 3, 5, 7, 4, 19, 26};
    int k = 3;
    System.out.println(printKthSmallestElement(a, 0, a.length-1, k));
  }

  private static int printKthSmallestElement(int[] a, int left, int right, int k) {
    int size = right - left + 1;
    if (k > 0 && k <= size) {
      int pivot = randomPartition(a, left, right);
      if (pivot - left == k - 1) {
        return a[pivot];
      }

      if (pivot > k-1) {
        return printKthSmallestElement(a, left, pivot - 1, k);
      } else {
        return printKthSmallestElement(a, pivot + 1, right, k - pivot + left - 1);
      }
    }
    return Integer.MAX_VALUE;
  }

  private static int randomPartition(int[] a, int left, int right) {
   int index = getRandomIndex(left, right);
    ArrayUtil.swap(a, left, left + index);

    int pivot = a[left];
    int i = left;
    int j = right;
    while (i < j) {
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

  private static int getRandomIndex(int left, int right) {
    Random random = new Random();
    return random.nextInt(right - left + 1);
  }
}
