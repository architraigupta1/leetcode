package com.archit.coding.practice.strings;

public class ReverseIndividualWords {
  public static void main(String[] args) {
    String str = "Geeks for Geeks";
    int start = 0;
    int end = 0;
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ' || i == str.length() - 1) {
        if (i == str.length() -1) {
          end = i;
        } else {
          end = i - 1;
        }
        reverseWord(sb, start, end);
        start = i + 1;
      }
    }
    System.out.print(sb.toString());
  }

  private static void reverseWord(StringBuilder sb, int start, int end) {
    while (start < end) {
      char temp = sb.charAt(start);
      sb.setCharAt(start, sb.charAt(end));
      sb.setCharAt(end, temp);
      start++;
      end--;
    }
  }
}
