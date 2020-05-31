package com.archit.coding.practice.strings;

/**
 * All chars must be used
 * One char must be used at only one position
 * Treat repeating chars as unique.
 */
public class PermutatuionsOfString {
  public static void main(String[] args) {
    String str = "abc";
    char[] original = str.toCharArray();
    char[] permutation = new char[str.length()];
    boolean[] usedChars = new boolean[str.length()];
    printPermutations(original, usedChars, permutation, 0, str.length());
  }

  private static void printPermutations(char[] original, boolean[] usedChars, char[] permutation, int index, int length) {
    if (index == length) {
      print(permutation);
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

  private static void print(char[] perm) {
    for (int i = 0; i < perm.length; i++) {
      System.out.print(perm[i]);
    }
    System.out.println();
  }
}
