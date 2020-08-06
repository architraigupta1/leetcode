package com.archit.coding.practice.strings;

public class PrintAllSubstringsOfString {
  public static void main(String[] args) {
    String input = "abcd";
    input = "Geeky";
    char[] c = input.toCharArray();

    //Fix every char to first index and recurse to get all
    // substrings with that index as first char
    for (int i = 0; i < c.length; i++) {
      StringBuilder sb = new StringBuilder();
      printSubstr(c, sb, i);
    }
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
