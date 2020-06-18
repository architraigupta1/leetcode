package com.archit.coding.practice.array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMinMaxSum {
  public static void main(String[] args) {
    int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
    int k = 3;
    System.out.println(SumOfKsubArray(arr, k));
  }

  private static int SumOfKsubArray(int[] a, int k) {
    Deque<Integer> minq = new LinkedList<>();
    Deque<Integer> maxq = new LinkedList<>();
    int sum = 0;

    for (int i = 0; i < k; i++) {
      while (!minq.isEmpty() && a[i] <= a[minq.peekLast()]) {
        minq.removeLast();
      }
      minq.addLast(i);

      while (!maxq.isEmpty() && a[i] >= a[maxq.peekLast()]) {
        maxq.removeLast();
      }
      maxq.addLast(i);
    }

    for (int i = k; i < a.length; i++) {
      sum += a[minq.peekFirst()] + a[maxq.peekFirst()];

      while (!minq.isEmpty() && minq.peekFirst() <= i-k) {
        minq.removeFirst();
      }

      while (!maxq.isEmpty() && maxq.peekFirst() <= i-k) {
        maxq.removeFirst();
      }

      while (!minq.isEmpty() && a[i] <= a[minq.peekLast()]) {
        minq.removeLast();
      }
      minq.addLast(i);

      while (!maxq.isEmpty() && a[i] >= a[maxq.peekLast()]) {
        maxq.removeLast();
      }
      maxq.addLast(i);
    }

    sum += a[minq.peekFirst()] + a[maxq.peekFirst()];
    return sum;
  }
}
