package com.archit.coding.practice;

import com.archit.coding.utils.Heap;

public class HeapFunctions {
  public static void main(String[] args) {
    Heap heap = new Heap(10);
    heap.print();
    heap.heapSort();
    heap.print();
  }
}
