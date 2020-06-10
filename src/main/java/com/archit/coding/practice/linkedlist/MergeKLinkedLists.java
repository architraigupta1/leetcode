package com.archit.coding.practice.linkedlist;

import com.archit.coding.utils.LinkedList;
import com.archit.coding.utils.Node;

public class MergeKLinkedLists {
  public static void main(String[] args) {
    int k = 5;
    int n = 4;
    LinkedList linkedList = new LinkedList();
    Node<Integer>[] heads = new Node[k];
    for (int i = 0; i < k; i++) {
      heads[i] = linkedList.createDummyLinkedList(n);
    }

    Node<Integer> mergedHead = mergeKLinkedList(heads, k);
    linkedList.print(mergedHead);
  }

  /**
   * This is the main function which pairs up lists (first,last) and stores the merged list in first.
   * It keeps on doing so until only one list remains.
   *
   * @param heads lists to merge
   * @param numberOfLists
   * @return head of merged list
   */
  private static Node<Integer> mergeKLinkedList(Node<Integer>[] heads, int numberOfLists) {
    int last = numberOfLists - 1;

    while(last != 0) {
      int i = 0;
      int j = last;

      while (i < j) {
        heads[i] = merge(heads[i], heads[j]);
        i++;
        j--;

        if (i >= j) {
          last = j;
        }
      }
    }
    return heads[0];

  }

  private static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
    if (a == null) {
      return b;
    }

    if (b == null) {
      return a;
    }

    if (a.data >= b.data) {
      a.next = merge(a.next, b);
      return a;
    } else {
      b.next = merge(a, b.next);
      return b;
    }
  }
}
