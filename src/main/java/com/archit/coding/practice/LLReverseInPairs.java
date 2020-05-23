package com.archit.coding.practice;

import com.archit.coding.utils.Node;

public class LLReverseInPairs {
  public static void main(String[] args) {
    com.archit.coding.utils.LinkedList linkedList = new com.archit.coding.utils.LinkedList();
    Node<Integer> head = linkedList.createDummyLinkedList(5);

    linkedList.print(head);
    head = linkedList.reverseBlockOfK(head, 3);
    linkedList.print(head);

  }
}
