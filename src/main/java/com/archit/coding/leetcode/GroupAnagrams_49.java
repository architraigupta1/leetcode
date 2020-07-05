package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
  public static void main(String[] args) {
    Solution s = new Solution();
    String strs [] = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> result = s.groupAnagrams(strs);
    System.out.print(result);
  }

  static class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> result = new ArrayList();

      if (strs == null || strs.length == 0) {
        return result;
      }

      if (strs.length == 1) {
        result.add(Arrays.asList(strs[0]));
        return result;
      }

      HashSet<String> set = new HashSet<>();

      for (int i = 0; i < strs.length; i++) {
        if (set.contains(strs[i])) {
          continue;
        }
        List<int[]> a = new ArrayList<>();
        List<String> cur = new ArrayList();
        cur.add(strs[i]);
        set.add(strs[i]);

        //count chars in string
        int[] count = prepareCountArray(strs[i]);

        for (int j = i+1; j < strs.length; j++) {
          if (set.contains(strs[j])) {
            continue;
          } else {
            int [] curCount = prepareCountArray(strs[j]);
            if (anagram(count, curCount)) {
              set.add(strs[j]);
              cur.add(strs[j]);
            }
          }
        }

        result.add(cur);
      }

      return result;

    }

    private int[] prepareCountArray(String s) {
      int[] count = new int[26];

      for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
      }

      return count;
    }

    private boolean anagram(int[] a, int[] b) {
      for (int i = 0; i < 26; i++) {
        if (a[i] != b[i]) {
          return false;
        }
      }

      return true;
    }
  }
}


