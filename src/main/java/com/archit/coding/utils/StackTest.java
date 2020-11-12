package com.archit.coding.utils;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    Iterator<Integer> it = stack.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
