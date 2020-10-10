package com.archit.coding.practice.strings;

public class RecursivelyRemoveAdjacentDuplicates {
  public static void main(String[] args) {
    String str = "geeksforgeekss";
//    str = "archit";
//    str = "caacbbbaacdddd";
    str = "acaaabbbacdddd";
    StringBuilder sb = new StringBuilder(str);
    System.out.println(sb.toString());
    int j = 0;
    for (int i = 1; i < sb.length(); i++) {
      if (sb.charAt(i) == sb.charAt(i-1)) {
        j = i-1;
        while (j >=0 && i < sb.length() && sb.charAt(j) == sb.charAt(i)) {
          j--;
          i++;
        }
        sb.delete(j+1, i);
        i = j+1;
      }
    }
    System.out.println(sb.toString());
  }
}
