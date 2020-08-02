package com.archit.coding.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionOps {
  public static void main(String[] args) {
    int[] a = {1,2,3};
    HashSet<Integer> set = new HashSet<>();
    
    List<Integer> list = new ArrayList<Integer>();
    set.addAll(list);

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {1,2});
    LinkedList<Integer> linkedList = new LinkedList<>();

    PriorityQueue<Integer> pq = new PriorityQueue<>();

  }
}
