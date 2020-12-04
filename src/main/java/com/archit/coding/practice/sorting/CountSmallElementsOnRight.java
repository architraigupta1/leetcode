package com.archit.coding.practice.sorting;

import com.archit.coding.utils.ArrayUtil;

public class CountSmallElementsOnRight {
  public static void main(String[] args) {
    int a[] = { 10, 9, 5, 2, 7, 6, 11, 0, 2 };
    Solution s = new Solution();
    ArrayUtil.printArray(s.countSmaller(a)); //7 6 3 1 3 2 2 0 0
  }

  static class Solution {
    public int[] countSmaller(int[] a) {
      int n = a.length;
      Node[] nodes = new Node[n];
      int[] count = new int[n];
      for (int i = 0; i < n; i++) {
        nodes[i] = new Node(a[i], i);
      }

      int left = 0;
      int right = n-1;
      mergeSort(nodes, left, right, count);
      return count;
    }

    private void mergeSort(Node[] nodes, int left, int right, int[] count) {
      if (left >= right) {
        return;
      }

      int mid = left + (right - left) / 2;
      mergeSort(nodes, left, mid, count);
      mergeSort(nodes, mid + 1, right, count);
      merge(nodes, left, mid, right, count);
    }

    private void merge(Node[] nodes, int left, int mid, int right, int[] count) {
      int size = right - left + 1;
      Node[] c = new Node[size];
      int k = 0;
      int i = left;
      int j = mid + 1;
      int counter = 0;

      while (i <= mid && j <= right) {
        if (nodes[i].value <= nodes[j].value) {
          count[nodes[i].index] += counter;
          c[k] = nodes[i];
          k++;
          i++;
        } else {
          c[k] = nodes[j];
          k++;
          j++;
          counter++;
        }
      }

      while (i <= mid) {
        c[k] = nodes[i];
        count[nodes[i].index] += counter;
        k++;
        i++;
      }

      while (j <= right) {
        c[k] = nodes[j];
        k++;
        j++;
      }
      k--;

      for (i = right; k >= 0; k--, i--) {
        nodes[i] = c[k];
      }
    }
  }

  static class Node {
    int value;
    int index;

    public Node (int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
