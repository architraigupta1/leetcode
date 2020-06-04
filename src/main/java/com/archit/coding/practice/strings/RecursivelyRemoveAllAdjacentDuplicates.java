package com.archit.coding.practice.strings;

public class RecursivelyRemoveAllAdjacentDuplicates {
  public static void main(String[] args) {
    String str = "caaabbbaacdddd";
    str = "acaaabbbacdddd";
    StringBuilder sb = new StringBuilder(str);
    System.out.println(sb.toString());
    int i = 0;
    while (i < sb.length() - 1) {
      if (sb.charAt(i) == sb.charAt(i+1)) {
        int j = i;
        while (j < sb.length() - 1 && sb.charAt(j) == sb.charAt(j+1)) {
          j++;
        }
        sb.delete(i, j+1);
        if (i!= 0) {
          i--;
        }
      } else {
        i++;
      }
    }
    System.out.println(sb.toString());
  }
}
