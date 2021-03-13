package com.archit.coding.test;

import java.util.ArrayList;
import java.util.List;

public class DiffBetweenStrings {
  public static void main(String[] args) {
    String[] ans = diffBetweenTwoStrings("ABCDEFG", "ABDFFGH");
    for (int i = 0; i < ans.length; i++) {
      System.out.printf(ans[i] + " ");
    }
  }

  static String[] diffBetweenTwoStrings(String source, String target) {
    // your code goes here

    //okay, I will take a look after the call.
    //Thanks a lot for your time and help
    //Leaving the call now. Thank you
    //but we have to return string[] and the array should contain chars with a '+' sign in front
    int n = source.length();
    int m = target.length();

    int i = 0;
    int j = 0;
    List<String> parts = new ArrayList<>();
    while(i < n && j < m) {
      char s = source.charAt(i);
      char d = target.charAt(j);

      if (s == d) {
        parts.add(String.valueOf(s));
        i++;
        j++;
      } else {
        parts.add("-"+ s);
        i++;
      }
//      "ABCDEFG", "ABDFFGH"
    }

    //when we come out of the while loop,  if we still hvae j < m that
    //means we need to add those chars

    while(j < m) {
      char d = target.charAt(j);
      parts.add("+" + d);
      j++;
    }

    return parts.toArray(new String[parts.size()]);
  }
}
