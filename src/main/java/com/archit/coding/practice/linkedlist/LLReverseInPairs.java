package com.archit.coding.practice.linkedlist;

import com.archit.coding.utils.Node;

public class LLReverseInPairs {
  public static void main(String[] args) {
    com.archit.coding.utils.LinkedList linkedList = new com.archit.coding.utils.LinkedList();
    Node<Integer> head = linkedList.createDummyLinkedList(7);

    linkedList.print(head);
    head = linkedList.reverseBlockOfKIterative(head, 3);
    linkedList.print(head);

  }
}
