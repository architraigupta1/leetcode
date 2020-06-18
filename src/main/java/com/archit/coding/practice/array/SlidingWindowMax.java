package com.archit.coding.practice.array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
  public static void main(String[] args) {
    int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
    int k = 3;
    printMax(arr, arr.length, k);
  }

  private static void printMax(int[] a, int length, int k) {
    Deque<Integer> dq = new LinkedList<>();

    for (int i = 0; i < k; i++) {
      while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
        dq.removeLast();
      }
      dq.addLast(i);
    }

    for (int i = k; i < length; i++) {
      System.out.print(a[dq.peekFirst()] + " ");

      while (!dq.isEmpty() && dq.peekFirst() <= i-k) {
        dq.removeFirst();
      }

      while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
        dq.removeLast();
      }
      dq.addLast(i);
    }

    System.out.print(a[dq.peekFirst()]);
  }
}
