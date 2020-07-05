package com.archit.coding.practice.strings;

public class KMPPatternMatchingAlgo {
  public static void main(String[] args) {
    String str = "abcxabcdabcdabcy";
    String pattern = "abcdabcy";
    System.out.print(kmp(str, pattern));
  }

  static boolean kmp(String str, String pattern) {
    int [] prefix = makePrefixArray(pattern);
    int n = str.length();
    int i = 0;
    int j = 0;
    while (i < n && j < pattern.length()) {
      if (str.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else if (j != 0){
        j = prefix[j - 1];
      } else {
        i++;
      }
    }
    if (j == pattern.length()) {
      return true;
    }
    return false;
  }

  private static int[] makePrefixArray(String pattern) {
    int n = pattern.length();
    int[] ch = new int[n];
    ch[0] = 0;
    int j = 0;
    int i = 1;
    while(i < n) {
      if (pattern.charAt(j) == pattern.charAt(i)) {
        ch[i] = j+1;
        j++;
        i++;
      } else if (j != 0){
        j = ch[j-1];
      } else {
        ch[i] = 0;
        i++;
      }
    }

    return ch;
  }
}
