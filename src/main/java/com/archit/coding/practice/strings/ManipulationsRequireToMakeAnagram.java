package com.archit.coding.practice.strings;

import java.util.HashMap;

public class ManipulationsRequireToMakeAnagram {
  public static void main(String[] args) {
    System.out.println(countManipulations("ddcf", "cedk"));
    System.out.println(countManipulations("abc", "abc"));
    System.out.println(countManipulations("abc", "def"));
  }

  private static int countManipulations(String s1, String s2) {
    HashMap<Character, Integer> dict = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      int c = 1;
      if (dict.containsKey(s1.charAt(i))) {
        c = dict.get(s1.charAt(i)) + 1;
      }
      dict.put(s1.charAt(i), c);
    }
    int count = 0;
    for (int i = 0; i < s2.length(); i++) {

      if (dict.containsKey(s2.charAt(i))) {
        int c = dict.get(s2.charAt(i));
        dict.put(s2.charAt(i), c-1);
        //char exists fewer times in s1 than in s2
        if (c <= 0) {
          count++;
        }
      } else {
        //char doesn't exist in s1
        count++;
      }
    }
    return count;
  }
}
