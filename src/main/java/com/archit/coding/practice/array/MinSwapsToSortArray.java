package com.archit.coding.practice.array;

import com.archit.coding.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSwapsToSortArray {
  public static void main(String[] args) {
    int []a = {1, 5, 4, 3, 2};
    MinSwapsToSortArray minSwapsToSortArray = new MinSwapsToSortArray();
    System.out.println(minSwapsToSortArray.minSwaps(a));
  }

  public int minSwaps(int[] a) {
    ArrayList<Pair<Integer, Integer>> ap = new ArrayList<>();

    //create a list of (element, current_position)
    for (int i = 0; i < a.length; i++) {
      ap.add(new Pair<>(a[i], i));
    }

    //sort the list by element so that all the elements come to their final position
    ap.sort((a1, b) -> {
      if (a1.getKey() > b.getKey()) {
        return 1;
      } else if (a1.getKey() == b.getKey()) {
        return 0;
      } else {
        return -1;
      }
    });

    //create a visited array to mark if the element has been moved to it's final position
    boolean[] visited = new boolean[a.length];
    Arrays.fill(visited, false);

    int swaps = 0;

    //Go over each element to calculate the number of swaps
    for (int i =0; i < a.length; i++) {
      // if the element is already at final position or moved to final position then continue
      if (visited[i] || ap.get(i).getValue() == i) {
        continue;
      }

      int j = i;
      int cycleSize = 0;
      // for current element, find out it's old position recursively
      // until you find a visited node. All these elements together form one cycle.
      while(!visited[j]) {
        //mark j as visited
        visited[j] = true;

        //get the old position of element at index j
        j = ap.get(j).getValue();

        //increment cycle size by 1
        cycleSize++;
      }

      if (cycleSize > 0) {
        swaps += cycleSize - 1;
      }
    }
    return swaps;
  }
}


