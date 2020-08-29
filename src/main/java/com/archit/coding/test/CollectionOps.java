package com.archit.coding.test;

import java.util.ArrayList;
import java.util.Arrays;
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
    list.toArray(new Integer[list.size()]);

    set.addAll(list);

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {1,2});
    LinkedList<Integer> linkedList = new LinkedList<>();

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    List<Integer> result = new ArrayList<>();
    result.toArray(new Integer[result.size()]);

    List<List<Integer>> r = new ArrayList<>();
    r.add(Arrays.asList());
    Integer[] arr = {1,2};
    r.add(Arrays.asList(arr));

  }
}
