package com.archit.coding.leetcode;

public class RegularExpressionMatching_10 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isMatch("ab", ".*c"));
  }

  static class Solution {
    public boolean isMatch(String s, String p) {
      if ((s == null && p == null) || s.isEmpty() && p.isEmpty()) {
        return true;
      }

      if ((!s.isEmpty() && p.isEmpty()) || (s.isEmpty() && !p.isEmpty())) {
        return false;
      }

      return check(s.toCharArray(), p. toCharArray(), 0, 0);
    }

    private boolean check(char[] a, char[] p, int i, int j) {
      int length = a.length;
      int plen = p.length;

      if(i == a.length && j == p.length) {
        return true;
      }

      char cur = i < a.length ? a[i] : ' ';
      char pcur = j < p.length ? p[j] : ' ';
      char next = j + 1 < plen ? p[j+1] : ' ';
      if (pcur == '.') {
        if (next == '*') {
          return check(a, p, i, j+2)
              || check(a, p, i+1, j)
              || check(a, p, i+1, j+2);
        } else {
          return check(a, p, i+1, j+1);
        }
      } else if (Character.isLetter(pcur)) {
        if (next == '*') {
          if (cur == pcur) {
            return check(a, p, i+1, j)
                || check(a, p, i, j+2)
                || check(a, p, i+1, j+2);
          } else {
            return check(a, p, i, j+2);
          }

        } else {
          if (cur == pcur) {
            return check(a, p, i+1, j+1);
          } else {
            return false;
          }
        }
      }

      return false;
    }
  }
}
