package com.archit.coding.practice.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckForValidStringWithOneRemoval {
  public static void main(String[] args) {
    String[] s = {"aabbbb", "aaab", "ab", "aab", "abbccd", "aabbcccc", "aaa"};
    CheckForValidStringWithOneRemoval sol = new CheckForValidStringWithOneRemoval();
    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i] + " : " + sol.isValid(s[i]));
    }

  }

  private boolean isValid(String s) {
    if (s == null || s.isEmpty() || s.length() == 1) {
      return true;
    }

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        int val = map.get(s.charAt(i));
        map.put(s.charAt(i), val + 1);
      } else {
        map.put(s.charAt(i), 1);
      }
    }

    boolean first = true;
    int firstCount = 0;
    int firstFreq = 0;
    boolean second = true;
    int secondCount = 0;
    int secondFreq = 0;

    Iterator<Integer> it = map.values().iterator();
    while(it.hasNext()) {
      int val = it.next();
      if (first) {
        first = false;
        firstFreq = val;
        firstCount++;
        continue;
      }

      if (val == firstFreq) {
        firstCount++;
        continue;
      }

      if (second) {
        second = false;
        secondFreq = val;
        secondCount++;
        continue;
      }

      if (val == secondFreq) {
        secondCount++;
        continue;
      }

      return false;
    }

    if (firstCount > 1 && secondCount > 1) {
      return false;
    } else if (firstCount == 1 && secondCount == 1) {
      int diff = Math.abs(firstFreq - secondFreq);
      if (firstFreq == 1 || secondFreq == 1 || diff == 1)
        return true;
      else
        return false;
    } else if (firstCount == 1) {
      if (firstFreq == 1 || (firstFreq - secondFreq == 1) || secondCount == 0)
        return true;
      else
        return false;
    } else if (secondCount == 1) {
      if (secondFreq == 1 || (secondFreq - firstFreq == 1))
        return true;
      else
        return false;
    }

     return true;
  }
}
