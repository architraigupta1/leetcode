package com.archit.coding.practice.strings;

public class PrintAllSubstringsOfString {
  public static void main(String[] args) {
    String input = "abcd";
    input = "Geeky";
    char[] c = input.toCharArray();
    for (int i = 0; i < c.length; i++) {
      StringBuilder sb = new StringBuilder();
      printSubstr(c, sb, i);
    }
  }

  private static void printSubstr(char[] c, StringBuilder sb, int i) {
    if (i == c.length) {
      return;
    }
    sb.append(c[i]);
    System.out.println(sb.toString());
    printSubstr(c, sb, i+1);
  }
}
