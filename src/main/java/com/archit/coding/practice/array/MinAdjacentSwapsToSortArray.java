package com.archit.coding.practice.array;

public class MinAdjacentSwapsToSortArray {
  public static void main(String[] args) {
    int arr[] = {1, 20, 6, 4, 5};
    int n = arr.length;
    System.out.println("Number of swaps is "
        + countSwaps(arr, n));
  }

  private static int countSwaps(int[] arr, int n) {
    return countSwapsMergeSort(arr, 0, n-1);
  }

  private static int countSwapsMergeSort(int[] arr, int left, int right) {
    int swaps = 0;
    if (left < right) {
      int mid = (left + right)/2;

      swaps += countSwapsMergeSort(arr, left, mid);
      swaps += countSwapsMergeSort(arr, mid + 1, right);
      swaps += countSwapsMerge(arr, left, mid + 1, right);
    }
    return swaps;
  }

  private static int countSwapsMerge(int[] a, int left, int mid, int right) {
    int size = right - left + 1;
    int[] b = new int[size];
    int i = left;
    int j = mid;
    int k = 0;
    int swaps = 0;

    while (i < mid && j <= right) {
      if (a[i] <= a[j]) {
        b[k++] = a[i++];
      } else {
        b[k++] = a[j++];
        swaps += mid - i;
      }
    }

    while (i < mid) {
      b[k++] = a[i++];
    }

    while (j <= right) {
      b[k++] = a[j++];
    }

    k = 0;
    for (int z = left; z <= right; z++, k++) {
      a[z] = b[k];
    }

    return swaps;
  }
}
