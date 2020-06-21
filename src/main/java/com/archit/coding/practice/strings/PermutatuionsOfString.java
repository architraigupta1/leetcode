package com.archit.coding.practice.strings;

import com.archit.coding.utils.ArrayUtil;

/**
 * All chars must be used
 * One char must be used at only one position
 * Treat repeating chars as unique.
 */
public class PermutatuionsOfString {
  public static void main(String[] args) {
    int[] a = {1,2,3};

    String str = "123";
    char[] original = str.toCharArray();
    char[] permutation = new char[str.length()];
    boolean[] usedChars = new boolean[str.length()];
    printPermutations(original, usedChars, permutation, 0, str.length());
  }

  private static void printPermutations(char[] original, boolean[] usedChars, char[] permutation, int index, int length) {
    if (index == length) {
      ArrayUtil.printCharArray(permutation);
      return;
    }

    for (int i = 0; i < length; i++) {
      if (!usedChars[i]) {
        usedChars[i] = true;
        permutation[index] = original[i];
        printPermutations(original, usedChars, permutation, index+1, length);
        usedChars[i] = false;
      }
    }
  }


}
