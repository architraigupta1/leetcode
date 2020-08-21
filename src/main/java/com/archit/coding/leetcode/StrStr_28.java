package com.archit.coding.leetcode;

public class StrStr_28 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.strStr("hello", "ll"));
  }

  static class Solution {
    public int strStr(String haystack, String needle) {
      if (needle == null || needle.length() == 0) {
        return 0;
      }

      if (haystack == null || haystack.length() == 0) {
        return -1;
      }

      int n = haystack.length();
      int m = needle.length();
      if (m > n) {
        return -1;
      }

      // RABIN KARP ALGO USING ROLLING HASH O(n)
      int needleHash = getHash(needle, 0, m-1);
      int haystackWindowHash = getHash(haystack, 0, m-1);
      for (int i = 1; i < n - m + 1; i++) {
        haystackWindowHash = updateHash(haystackWindowHash, haystack,
            i-1, i + m - 1);
        if (haystackWindowHash == needleHash) {
          int k = i;
          int j = 0;
          while (k < n && j < m && haystack.charAt(k) == needle.charAt(j)) {
            k++;
            j++;
          }
          if (j == m) {
            return i;
          } else if (k == n) {
            return -1;
          }
        }

      }

      return -1;
    }

    private int getHash(String s, int start, int end) {
      int l = 0;
      int hash = 0;
      int prime = 3;
      for (int i = start; i <= end; i++) {
        int index = s.charAt(i) - 'a';
        hash += (int)(index * Math.pow(prime, l));
        hash = hash % Integer.MAX_VALUE;
        l++;
      }

      return hash;
    }

    private int updateHash(int hash, String s, int left, int right) {
      int prime = 3;
      hash -= (s.charAt(left) - 'a');
      hash /= prime;
      hash += (s.charAt(right) - 'a') * Math.pow(prime, right - left - 1);
      hash = hash % Integer.MAX_VALUE;

      return hash;
    }

  }
}
