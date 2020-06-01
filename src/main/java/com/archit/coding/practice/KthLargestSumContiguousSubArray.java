package com.archit.coding.practice;

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubArray {
  public static void main(String[] args) {
//    int[] a = {20, -5, -1};
    int[] a = {10, -10, 20, -40};
    int k = 6;

    System.out.println(k + " largest sum is " + kthLargetSum(a, k));
  }

  public static int kthLargetSum(int[] a, int k) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);


    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = i; j < a.length; j++) {
        sum += a[j];
        if (priorityQueue.size() < k) {
          priorityQueue.add(sum);
        } else {
          int min = priorityQueue.peek();
          if (sum > min) {
            priorityQueue.poll();
            priorityQueue.add(sum);
          }
        }
      }
    }
    return priorityQueue.peek();
  }
}
