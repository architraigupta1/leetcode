package com.archit.coding.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStream {
  static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  static double median = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int data = 1;
    while(data != 0) {
      data = scanner.nextInt();
      System.out.println(printMedianInStream(data));
    }
  }


  private static double printMedianInStream(int data) {
    if (maxHeap.size() > minHeap.size()) {
      if (data < median) {
        int maxTop = maxHeap.poll();
        maxHeap.add(data);
        minHeap.add(maxTop);
      } else {
        minHeap.add(data);
      }
      median = (double)(maxHeap.peek() + minHeap.peek()) / 2;
    } else if (maxHeap.size() == minHeap.size()) {
      if (data < median) {
        maxHeap.add(data);
        median = (double) maxHeap.peek();
      } else {
        minHeap.add(data);
        median = (double) minHeap.peek();
      }
    } else {
      if (data < median) {
        maxHeap.add(data);
      } else {
        int minTop = minHeap.poll();
        minHeap.add(data);
        maxHeap.add(minTop);
      }
      median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }
    return median;
  }
}