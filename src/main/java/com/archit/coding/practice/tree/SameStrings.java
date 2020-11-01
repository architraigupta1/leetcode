package com.archit.coding.practice.tree;

/*
* Similar strings ("face", "eacf") returns true if only 2 positions in the strings are swapped.
*  Here 'f' and 'e' are swapped in the example.
* */
public class SameStrings {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isSimilar("face", "acef"));
  }

  static class Solution {
    public boolean isSimilar(String a, String b) {
      if (a == null && b == null) {
        return true;
      }

      int alen = a.length();
      int blen = b.length();
      if (alen != blen) {
        return false;
      }

      int count = 0;
      int [] diff = new int[2];
      for (int i = 0; i < alen; i++) {
        if (a.charAt(i) != b.charAt(i)) {
          if (count == 2) {
            return false;
          } else {
            diff[count] = i;
            count++;
          }
        }
      }

      return count == 0
          || (count == 2
          && a.charAt(diff[0]) == b.charAt(diff[1])
          && a.charAt(diff[1]) == b.charAt(diff[0]));
    }
  }
}
