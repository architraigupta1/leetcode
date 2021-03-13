package com.archit.coding.test;

public class PalindromicString {
  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  public static boolean isPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return true;
    }

    int n = s.length();
    int i = 0;
    int j = n-1;

    while(i < j) {
      char first = s.charAt(i);
      char last = s.charAt(j);
      if (!Character.isLetterOrDigit(first)) {
        i++;
      } else if (!Character.isLetterOrDigit(last)) {
        j--;
      } else if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
        i++;
        j--;
      } else {
        return false;
      }

    }

    return true;
  }
}
