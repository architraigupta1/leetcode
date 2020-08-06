package com.archit.coding.practice.strings;



public class CombinationsOfString {
  public static void main(String[] args) {
    String str = "abc"; //    a, b, c, ab, ac, bc, abc
    char[] original = str.toCharArray();
    StringBuilder combination = new StringBuilder();
    printCombinations(original, combination, 0, str.length());

  }

  private static void printCombinations(char[] original, StringBuilder combination, int index, int length) {

    for (int i = index; i < length; i++) {
      StringBuilder sb = new StringBuilder(combination);
      sb.append(original[i]);
      System.out.println(sb.toString());
      printCombinations(original, sb, i + 1, length);
    }

  }

}
