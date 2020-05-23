package com.archit.coding.utils;

public class LinkedList {

  public Node<Integer> createDummyLinkedList(int size) {

    Node<Integer> head = new Node<>(1);
    head.next = null;

    for (int i = 2; i <= size; i++) {
      Node<Integer> node = new Node<>(i);
      node.next = head;
      head = node;

    }
    return head;
  }

  public boolean hasKNodes(Node head, int k) {
    Node temp = head;
    int i;
    for (i = 0; i < k && temp != null; i++, temp = temp.next);

    return i == k;
  }

  public Node getKPlusOneNode(Node head, int k) {
    Node temp = head;
    if (head == null) {
      return null;
    }

    int i = 0;
    for (i = 0; i < k && temp != null; i++, temp = temp.next);

    return (i == k && temp != null) ? temp : head.next;
  }

  public void print(Node head) {
    System.out.println();
    while (head != null) {
      System.out.print(head.data + "-->");
      head = head.next;
    }
    System.out.println();
  }

  public Node reverseBlockOfK(Node head, int k) {
      Node current = head;
      Node next = null;
      Node prev = null;
      int count = 0;

      if (!hasKNodes(head, k)) {
        return head;
      }
      /* Reverse first k nodes of linked list */
      while (count < k && current != null)
      {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        count++;
      }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
      if (next != null)
        head.next = reverseBlockOfK(next, k);

      // prev is now head of input list
      return prev;
    }
  }
