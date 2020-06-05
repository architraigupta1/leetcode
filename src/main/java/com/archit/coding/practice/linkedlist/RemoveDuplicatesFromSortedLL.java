package com.archit.coding.practice.linkedlist;

import java.util.LinkedList;

public class RemoveDuplicatesFromSortedLL {
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(1);
    linkedList.add(1);
    linkedList.add(1);
    linkedList.add(3);
    linkedList.add(5);
    linkedList.add(5);

    linkedList.forEach(i -> System.out.print(i + " "));
    RemoveDuplicatesFromSortedLL rm = new RemoveDuplicatesFromSortedLL();
    rm.removeDuplicates(linkedList, 0);
    linkedList.forEach(i -> System.out.print(i + " "));
  }

  private void removeDuplicates(LinkedList<Integer> linkedList, int head) {
    if (head == linkedList.size() - 1) {
      return;
    }
    if (linkedList.get(head) == linkedList.get(head + 1)) {
      linkedList.remove(head + 1);
      removeDuplicates(linkedList, head);
    } else {
      removeDuplicates(linkedList, head + 1);
    }

  }
}
