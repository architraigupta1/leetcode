package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
  class Solution {
    public int[] twoSum(int[] nums, int target) {
      int [] result = new int[2];
      Map<Integer, Integer> hash = new HashMap();
      for(int i = 0; i< nums.length; i++) {
        int complement = target - nums[i];
        if(hash.containsKey(complement)) {
          result[0] = hash.get(complement);
          result[1] = i;
          return result;
        }
        hash.put(nums[i], i);
      }
      return result;
    }
  }
}
