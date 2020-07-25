package com.archit.coding.test;

import com.archit.coding.utils.ArrayUtil;

public class ArrayOps {
  public static void main(String[] args) {
    int[][] r = new int[2][2];
    int [] a = new int[] {1,2};

    r[0] = a;
    r[1][0] = a[0];
    r[1][1] = a[1];
    ArrayUtil.print2DArray(r);
  }
}
