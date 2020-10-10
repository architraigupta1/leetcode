package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations2_47 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {1,1,2};
    List<List<Integer>> result = s.permuteUnique(a);
    System.out.println();
  }

  static class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null || nums.length == 0) {
        return result;
      }

      int n = nums.length;
      int [] perm = new int[n];
      boolean[] visited = new boolean[n];
      Map<String, List<Integer>> map = new HashMap<>();
      generatePermutations(nums, 0, n, perm, visited, map);
      result.addAll(map.values());
      return result;
    }

    private void generatePermutations(int[] nums, int index,
                                      int n, int[] perm, boolean[] visited,
                                      Map<String, List<Integer>> map) {
      if (index == n) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
          sb.append(perm[i]).append("_");
          list.add(perm[i]);
        }
        String key = sb.toString();
        if(!map.containsKey(key)) {
          map.put(key, list);
        }

        return;
      }

      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          visited[i] = true;
          perm[index] = nums[i];
          generatePermutations(nums, index + 1, n, perm, visited, map);
          visited[i] = false;
        }
      }

    }
  }
}
