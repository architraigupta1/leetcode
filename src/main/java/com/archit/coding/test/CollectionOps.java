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
    
    List<Integer> list = new ArrayList<>();
    list.toArray(new Integer[list.size()]);
    list.toArray(new Integer[0]);


    set.addAll(list);

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {1,2});
    LinkedList<Integer> linkedList = new LinkedList<>();

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    List<Integer[]> result = new ArrayList<>();
    int a1 = 1;
    int b1 = 2;
    if (a1>=b1) {
      
    }

    List<List<Integer>> r = new ArrayList<>();
    r.add(Arrays.asList());
    Integer[] arr = {1,2};
    int[] ax = {1,2};
    r.add(Arrays.asList(arr));

  }

}
