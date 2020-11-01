package com.archit.coding.practice.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedList {
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(1);
    linkedList.add(5);
    linkedList.add(2);
    linkedList.add(5);
    linkedList.add(3);

    linkedList.forEach(item -> System.out.print(item + " -> "));
    removeDuplicates(linkedList);
    System.out.println();
    linkedList.forEach(item -> System.out.print(item + " -> "));
  }

  private static void removeDuplicates(LinkedList<Integer> linkedList) {
    if (linkedList == null || linkedList.size() < 2) {
      return;
    }

    Set<Integer> set = new HashSet<>();
    int i = 0;
    while(i < linkedList.size()) {
      if (set.contains(linkedList.get(i))) {
        linkedList.remove(i);
      } else {
        set.add(linkedList.get(i));
        i++;
      }
    }

  }
}
