package com.archit.coding.leetcode;

public class ValidPalindrome {
  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));
  }

  static public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int left = 0;
    int right = s.length() - 1;
    s = s.toLowerCase();
    while(left < right) {
      char l = s.charAt(left);
      char r = s.charAt(right);
      if (!Character.isLetterOrDigit(l)) {
        left++;
      } else if (!Character.isLetterOrDigit(r)) {
        right--;
      } else if (l == r) {
        left++;
        right--;
      } else {
        return false;
      }
    }

    return true;
  }
}
