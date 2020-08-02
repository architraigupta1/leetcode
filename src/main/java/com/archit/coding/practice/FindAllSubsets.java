package com.archit.coding.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllSubsets {
  public static void main(String[] args) {
    int[] a = {1,5,3};
    List<HashSet<Integer>> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    result.add(set);

    getAllSets(a, 0, set, result);
    System.out.println();

  }

  private static void getAllSets(int[] a, int index, HashSet<Integer> set, List<HashSet<Integer>> result) {


    for (int i = index; i < a.length; i++) {
      HashSet<Integer> cur = new HashSet<>();
      cur.addAll(set);
      cur.add(a[i]);
      result.add(cur);
      getAllSets(a, i + 1, cur, result);
    }
  }
}
