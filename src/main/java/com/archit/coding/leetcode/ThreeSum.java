package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
  public static void main(String[] args) {
    Solution s = new Solution();
    int [] a = {-1,0,1,2,-1,-4};
    s.threeSum(a);
    System.out.println();
  }

  static class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null || nums.length < 3) {
        return result;
      }

      int n = nums.length;

      //sort the input array
      Arrays.sort(nums);

      //for every element as first element
      for (int i = 0; i < n; i++) {
        //if a[i] == a[i-1], continue because it will give a duplicate solution
        if (i > 0 && nums[i] == nums[i-1]) {
          continue;
        }

        //take two pointers, one at start and one at end
        int j = i+1;
        int k = n-1;
        while(j < k) {
          int sum = nums[i] + nums[j] + nums[k];

          if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            j++;
            k--;
          }

          //we have considered elements at j and k, consume similar elements
          while(j < k && nums[j] == nums[j+1]) {
            j++;
          }

          while(j < k && nums[k] == nums[k-1]) {
            k--;
          }

          if (sum < 0) {
            j++;
          } else if (sum > 0) {
            k--;
          }
        }
      }

      return result;
        /*
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        //prepare a map of element, index
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        //for every element as first element
        for (int i = 0; i < n; i++) {
            //for every element as second element
            for (int j = i + 1; j < n; j++) {
                //third element will be negative of a + b
                int key = -(nums[i] + nums[j]);
                //if map has it then, check for duplicacy
                if (map.containsKey(key)) {
                    int index = map.get(key);
                    if (index != i && index != j) {
                        //if not duplicate, add to the result set
                        if (!checkDuplicate(set, nums[i], nums[j], key)) {
                            result.add(Arrays.asList(nums[i], nums[j], key));
                        }
                    }
                }
            }
        }

        return result;
        */

    }

    private boolean checkDuplicate(HashSet<String> set, int a, int b, int c) {
      List<Integer> list = Arrays.asList(a, b, c);
      //sort the three numbers
      Collections.sort(list);
      StringBuilder sb = new StringBuilder();
      //prepare a key 1#2#3#
      for (int num : list) {
        sb.append(String.valueOf(num)).append("#");
      }
      String key = sb.toString();
      //if the key exist in set => we already have this solution
      if (set.contains(key)) {
        return true;
      } else {
        //we saw this solution first time, add it to set
        set.add(key);
        return false;
      }

    }
  }
}
