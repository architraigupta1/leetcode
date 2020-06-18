package com.archit.coding.practice.heap;

import java.util.PriorityQueue;

public class MthSmallestInKSortedArray {
  public static void main(String[] args) {
    int a[][] = {
        {1, 3},
        {2, 4, 6},
        {0, 9, 10, 11}
    };

    int m = 5;

    MthSmallestInKSortedArray sol = new MthSmallestInKSortedArray();
    System.out.print(sol.findMthSmallest(a, m));
  }

  private int findMthSmallest(int[][] a, int m) {
    int k = a.length;
    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> {
      if (x.data <= y.data) {
        return -1;
      } else if (x.data > y.data) {
        return 1;
      } else {
        return 0;
      }
    });

    for (int i = 0; i < k; i++) {
      Pair pair = new Pair(a[i][0], i, 0);
      pq.add(pair);
    }

    int j = 0;
    int result = Integer.MIN_VALUE;
    while(j < m && !pq.isEmpty()) {
      Pair temp = pq.poll();
      result = temp.data;

      if (a[temp.list].length > temp.index + 1) {
        Pair newEntry = new Pair(a[temp.list][temp.index + 1], temp.list, temp.index + 1);
        pq.add(newEntry);
      }
      j++;
    }
    return result;
  }

  class Pair {
    int data;
    int list;
    int index;

    public Pair(int data, int list, int index) {
      this.data = data;
      this.list = list;
      this.index = index;
    }
  }
}
