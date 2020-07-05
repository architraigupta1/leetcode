package com.archit.coding.practice.strings;

public class RabinKarpPatternMatchingAlgo {
  public static void main(String[] args) {
    String pattern = "abe";
    String str = "abedabc";
    int k = pattern.length();
    int n = str.length();

    int prime = 3;
    int hash = 0;
    for (int i = 0; i < k; i++) {
      hash += pattern.charAt(i) * Math.pow(prime, i);
    }
    System.out.println("Hash of pattern : " + hash);

    int shash = 0;
    for (int i = 0; i < k; i++) {
      shash += str.charAt(i) * Math.pow(prime, i);
    }

    if (shash == hash) {
      int j = 0;
      for (; j < k; j++) {
        if (pattern.charAt(j) != str.charAt(j)) {
          break;
        }
      }
      if (j == k) {
        System.out.println("Match found at index : " + 0);
      }
    }

    for (int i = 1; i < n - k + 1; i++) {
      shash = shash - str.charAt(i-1);
      shash /= prime;
      shash += str.charAt(i + k - 1) * Math.pow(prime, k-1);
      if (shash == hash) {
        int j = 0;
        for (; j < k; j++) {
          if (pattern.charAt(j) != str.charAt(i+j)) {
            break;
          }
        }
        if (j == k) {
          System.out.println("Match found at index : " + i);
          break;
        }
      }
    }
  }
}
