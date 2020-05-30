package com.archit.coding.utils;

import java.util.Random;

public class Heap {

  private int[] a;
  private int count;
  private int size;

  public Heap(int size) {
    this.size = size;
    this.count = size;
    this.a = new int[this.size];
    this.init();
  }

  public boolean isEmpty() {
    return this.count == 0;
  }

  public int firstNonLeafNode() {
    return (this.count - 1)/2;
  }

  public int parent(int child) {
    if (this.count == 0 || child <= 0 || child >= this.size) {
      return -1;
    }
    return (child - 1)/2;
  }

  public int leftChild(int parent) {
    if (this.isEmpty() || parent < 0) {
      return -1;
    }
    int leftChild = 2 * parent + 1;

    return leftChild >= this.size ? -1 : leftChild;
  }

  public int rightChild(int parent) {
    if (this.isEmpty() || parent < 0) {
      return -1;
    }
    int rightChild = 2 * parent + 2;

    return rightChild >= this.size ? -1 : rightChild;
  }

  public void percolateDown(int i) {
    if (this.isEmpty() || i > this.firstNonLeafNode()) {
      return;
    }
    int max;
    int leftChild = this.leftChild(i);
    int rightChild = this.rightChild(i);

    if (leftChild != -1 && this.a[leftChild] >= this.a[i]) {
      max = leftChild;
    } else {
      max = i;
    }

    if (rightChild != -1 && this.a[rightChild] >= this.a[max]) {
      max = rightChild;
    }

    if (max != i) {
      int temp = this.a[i];
      this.a[i] = this.a[max];
      this.a[max] = temp;
      percolateDown(max);
    }
  }

  public void percolateUp(int i) {
    if (this.isEmpty() || i <= 0) {
      return;
    }

    int data = this.a[i];
    while(i >= 0 && data >= this.a[this.parent(i)]) {
      this.a[i] = this.a[this.parent(i)];
      i = this.parent(i);
    }

    this.a[i] = data;
  }

  public void buildHeap() {
    if (isEmpty()) {
      return;
    }
    for (int i = this.firstNonLeafNode(); i >= 0; i--) {
      percolateDown(i);
    }
    this.print();
  }

  public void heapSort() {
    this.buildHeap();
    int oldSize = this.size;
    for (int i = this.size - 1; i >= 0; i--) {
      int temp = a[i];
      this.a[i] = a[0];
      a[0] = temp;
      this.size--;
      percolateDown(0);
    }
    this.size = oldSize;
  }

  public void init() {
    Random random = new Random();
    for (int i = 0; i < this.size; i++) {
      this.a[i] = random.nextInt(this.size) + 1;
    }
  }

  public void print() {
    for (int i = 0; i < this.size; i++) {
      System.out.print(this.a[i] + " ");
    }
    System.out.println();
  }

}
