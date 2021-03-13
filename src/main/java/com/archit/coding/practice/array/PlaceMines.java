package com.archit.coding.practice.array;

import com.archit.coding.utils.ArrayUtil;

import java.util.Random;

public class PlaceMines {
  public static void main(String[] args) {
    int rows = 5;
    int cols = 6;
    int[][] a = new int[rows][cols];
    ArrayUtil.print2DArray(a);
    int mines = 10;
    int[] res = new int[mines];
    for (int i = 0; i < mines; i++) {
      res[i] = i;
    }
    ArrayUtil.printArray(res);

    Random random = new Random();
    for (int i = mines; i < rows * cols; i++) {
      int value = random.nextInt(i);
      if (value < mines) {
        res[value] = i;
      }
    }

    ArrayUtil.printArray(res);

    for (int i = 0; i < mines; i++) {
      int value = res[i];
      int row = res[i] / cols;
      int col = res[i] % cols;
      a[row][col] = 1;
    }

    ArrayUtil.print2DArray(a);
  }
}
