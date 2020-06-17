package com.archit.coding.practice.strings;

import java.util.Arrays;

// can be done in o(n) using counting sort as chars are fixed to be [A-Z0-9]
public class SortTheStringWithNumbers {
  public static void main(String[] args) {
    String s = "AC2BEW3";
    int sum = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch - '0' >= 0 && ch - '0' <= 9) {
        sum += (ch - '0');
      } else {
        sb.append(ch);
      }
    }

    char result [] = sb.toString().toCharArray();
    Arrays.sort(result);
    sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      sb.append(result[i]);
    }
    sb.append(sum);
    System.out.print(sb.toString());
  }
}
