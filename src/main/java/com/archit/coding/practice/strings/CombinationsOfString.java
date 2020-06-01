package com.archit.coding.practice.strings;

import com.archit.coding.utils.ArrayUtil;

public class CombinationsOfString {
  public static void main(String[] args) {
    String str = "abc";
    char[] original = str.toCharArray();
    String combination = "";
    printCombinations(original, combination,0, 0, str.length());

  }

  private static void printCombinations(char[] original, String combination, int start, int index, int length) {
    if (index == length) {
      return;
    }
    for (int i = start; i < length; i++) {
      String localOriginal = combination;
      combination += original[i];
      System.out.println(combination);
      printCombinations(original, combination, i + 1, index + 1, length);
      combination = localOriginal;
    }

  }

}
