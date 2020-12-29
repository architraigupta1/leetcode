package com.archit.coding.practice.strings;

public class PrintAllSubstringsOfString {
  public static void main(String[] args) {
    String input = "abcd";
    input = "Geeky";
    char[] c = input.toCharArray();

    printSub(c, 0, c.length);

    //Fix every char to first index and recurse to get all
    // substrings with that index as first char
//    for (int i = 0; i < c.length; i++) {
//      StringBuilder sb = new StringBuilder();
//      printSubstr(c, sb, i);
//    }
  }

  private static void printSub(char[] c, int index, int length) {
    if (index == length) {
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = index; i < length; i++) {
      sb.append(c[i]);
      System.out.println(sb.toString());
    }
    printSub(c, index + 1, length);
  }

  private static void printSubstr(char[] c, StringBuilder sb, int index) {
    if (index == c.length) {
      return;
    }
    sb.append(c[index]);
    System.out.println(sb.toString());
    printSubstr(c, sb, index+1);
  }
}
