package com.archit.coding.practice.array;

public class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    int a[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
    int n = a.length;

    int index = 1;

    for (int i = 1; i < n; i++) {
      if (a[i] != a[i-1]) {
        a[index] = a[i];
        index++;
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
  }
}
