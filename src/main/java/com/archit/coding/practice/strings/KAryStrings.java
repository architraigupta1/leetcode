package com.archit.coding.practice.strings;

import com.archit.coding.utils.ArrayUtil;

public class KAryStrings {
  public static void main(String[] args) {
    KAryStrings kAryStrings = new KAryStrings();
    int[] a = new int[3];
    kAryStrings.printKAryOfSizeN(a, 3, 2);
    System.out.println("printing with v2");
    kAryStrings.printKAryOfSizeNV2(a,3,2, 0);
  }

  public void printKAryOfSizeN(int[] a, int n, int k) {
    if (n < 1) {
      ArrayUtil.printArray(a);
    } else {
      for (int i = 0; i < k; i++) {
        a[n-1] = i;
        printKAryOfSizeN(a, n-1, k);
      }
    }
  }

  public void printKAryOfSizeNV2(int[] a, int n, int k, int index) {
    if (index == n) {
      ArrayUtil.printArray(a);
      return;
    }
    for (int i = 0; i < k; i++) {
      a[index] = i;
      printKAryOfSizeNV2(a, n, k, index+1);
    }
  }
}
