package com.archit.coding.practice;

public class KAryStrings {
  public static void main(String[] args) {
    KAryStrings kAryStrings = new KAryStrings();
    int[] a = new int[3];
    kAryStrings.printKAryOfSizeN(a, 3, 3);
  }

  public void printKAryOfSizeN(int[] a, int n, int k) {
    if (n < 1) {
      print(a);
    } else {
      for (int i = 0; i < k; i++) {
        a[n-1] = i;
        printKAryOfSizeN(a, n-1, k);
      }
    }
  }

  public void print(int[] a) {
    for (int value : a) {
      System.out.print(value);
    }
    System.out.println();
  }
}
