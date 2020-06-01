package com.archit.coding.practice;

public class KadanesLargestSumContiguousSubArray {
  public static void main(String[] args) {
    int a[] = {-3, -2, -1, 7, -7, 10};
    int max_so_far = Integer.MIN_VALUE;
    int max_ending_here = 0;
    int start = 0;
    int end = 0;
    int s = 0;

    for (int i = 0; i < a.length; i++) {
      max_ending_here += a[i];
      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
        start = s;
        end = i;
      }
      if (max_ending_here < 0) {
        max_ending_here = 0;
        s = i+1;
      }

    }

    System.out.println("max : " + max_so_far);

    for (int i = start; i <= end; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
}
