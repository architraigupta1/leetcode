package com.archit.coding.utils;

import java.util.Random;

public class  ArrayUtil {

  public static int[] getRandomArray(int size) {
    return getRandomArray(size, size,false);
  }

  public static int[] getRandomArray(int size, int bound, boolean startFromZero) {
    Random random = new Random();


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


}
