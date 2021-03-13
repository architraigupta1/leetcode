package com.archit.coding.utils;

import java.util.List;
import java.util.Random;

public class  ArrayUtil {

  final static Random random = new Random();

  public static int[] getRandomArray(int size) {
    return getRandomArray(size, size,false);
  }

  public static int[] getRandomArray(int size, int bound, boolean startFromZero) {
    int[] a = new int[size];

    int minRandom = 1;
    if (startFromZero) {
      minRandom = 0;
    }
    for (int i = 0; i < size; i++) {
      a[i] = random.nextInt(bound) + minRandom;
    }

    return a;
  }

  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  public static void print2DArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void printCharArray(char[] perm) {
    for (int i = 0; i < perm.length; i++) {
      System.out.print(perm[i]);
    }
    System.out.println();
  }

  public static void printArray(String [] str) {
    for (int i = 0; i < str.length; i++) {
      System.out.println(str[i]);
    }
  }

  public static void printIntegerList(List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public static void printStringList(List<String> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public static int quickSelectKthLargest(int[] a, int k) {
    int n = a.length;
    int kthSmallestIdx = n - k;
    return quickSelectKthSmallest(a, kthSmallestIdx);
  }

  private static int quickSelectKthSmallest(int[] a, int k) {
    int n = a.length;
    return quickSelectKthIdx(a, 0, n-1, k);
  }

  private static int quickSelectKthIdx(int[] a, int left, int right, int k) {
    if (left > right || k < left || k > right) {
      return Integer.MAX_VALUE;
    }

    int pivot = getPivot(a, left, right);
    if (pivot == k) {
      return a[k];
    } else if (pivot > k) {
      return quickSelectKthIdx(a, left, pivot - 1, k);
    } else {
      return quickSelectKthIdx(a, pivot + 1, right, k);
    }
  }

  public static void quickSort(int[] a) {
    int n = a.length;
    int low = 0;
    quickSortRecursive(a, 0, n-1);
  }

  private static void quickSortRecursive(int[] a, int low, int high) {
    if (low < high) {
      int pivot = getPivot(a, low, high);
      quickSortRecursive(a, low, pivot - 1);
      quickSortRecursive(a, pivot + 1, high);
    }
  }

  private static int getPivot(int[] a, int low, int high) {
    int randomIndex = getRandomBetween(low, high);
    swap(a, low, randomIndex);
    int pivot = a[low];
    int i = low;
    int j = high;
    while(i < j) {
      while(i <= high && a[i] <= pivot) {
        i++;
      }

      while(j >= low && a[j] > pivot) {
        j--;
      }

      if (i < j) {
        swap(a, i, j);
      }
    }
    a[low] = a[j];
    a[j] = pivot;
    return j;
  }

  private static int getRandomBetween(int low, int high) {
    int size = high - low + 1;
    int r = random.nextInt(size);
    return low + r;
  }

  public static void sort(int[] a) {
    int n = a.length;

    mergeSort(a, 0, n-1);
  }

  private static void mergeSort(int[] a, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(a, left, mid);
      mergeSort(a, mid + 1, right);
      merge(a, left, mid, right);
    }
  }

  private static void merge(int[] a, int left, int mid, int right) {
    int i = left;
    int j = mid+1;
    int k = 0;
    int size = right - left + 1;
    int[] b = new int[size];

    while(i <= mid && j <= right) {
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

    while(j <= right) {
      b[k] = a[j];
      j++;
      k++;
    }

    for (i = left, k = 0; k < size; k++, i++) {
      a[i] = b[k];
    }
  }


}
