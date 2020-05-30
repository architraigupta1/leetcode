package com.archit.coding.utils;

import java.util.Random;

public class ArrayUtil {

  public static int[] getRandomArray(int size) {
    Random random = new Random();
    int[] a = new int[size];

    for (int i = 0; i < size; i++) {
      a[i] = random.nextInt(size) + 1;
    }

    return a;
  }

  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
